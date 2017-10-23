/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import java.util.Date;
import java.util.Arrays;
import java.util.Set;
import java.util.LinkedHashSet;
import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/gerenciamento/produto")
public class GerenciaProdutoController {

  @Autowired
  private ProdutoService produtoService;
  
//  @Autowired
//  private ProdutoRepository produtoRepository;

  @Autowired
  private CategoriaService categoriaService;

  @RequestMapping
  public ModelAndView abrirFormulario() {
    return new ModelAndView("produto/input")
	    .addObject("produto", new Produto())
	    .addObject("categorias", categoriaService.listar());
  }
  
  @RequestMapping("/{idProd}")
  public ModelAndView editar(@PathVariable("idProd")Long idProduto) {
    Produto p = produtoService.obter(idProduto);
    if (p.getCategorias() != null && !p.getCategorias().isEmpty()) {
      Set<Integer> idsCategorias = new LinkedHashSet<Integer>();
      for (Categoria c : p.getCategorias()) {
	idsCategorias.add(c.getId());
      }
      p.setIdsCategorias(idsCategorias);
    }
    return new ModelAndView("produto/input")
	    .addObject("produto", p)
	    .addObject("categorias", categoriaService.listar());
  }

  @RequestMapping(value = "/incluir", method = RequestMethod.POST)
  public ModelAndView incluir(@ModelAttribute("produto") @Valid Produto p,
	  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
      return new ModelAndView("produto/input").addObject("categorias", categoriaService.listar());
    }
    p.setDtCadastro(new Date());
    
    Set<Categoria> categoriasSelecionadas = new LinkedHashSet<Categoria>();
    if (p.getIdsCategorias() != null && !p.getIdsCategorias().isEmpty()) {
      for (Integer i : p.getIdsCategorias()) {
	Categoria c = categoriaService.obter(i);
	c.setProdutos(new LinkedHashSet<Produto>(Arrays.asList(p)));
	categoriasSelecionadas.add(c);
      }
      p.setCategorias(categoriasSelecionadas);
    }
    
    if (p.getId() == null) {
      produtoService.incluir(p);
    } else {
      produtoService.alterar(p);
    }
    
    redirectAttributes.addFlashAttribute("msgSucesso", p.getNome());
    return new ModelAndView("redirect:/gerenciamento/produto");
  }
  
  @RequestMapping(path = "/excluir/{idProd}")
  public ModelAndView excluir(@PathVariable("idProd") Long idProduto,
	  RedirectAttributes redirectAttributes) {
    produtoService.remover(idProduto);
    redirectAttributes.addFlashAttribute("msgSucesso", "Apagado com sucesso");
    return new ModelAndView("redirect:/gerenciamento/produto");
  }
}
