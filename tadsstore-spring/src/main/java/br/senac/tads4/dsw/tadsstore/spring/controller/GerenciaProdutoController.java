/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import java.util.HashSet;
import java.util.Date;
import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.ImagemProduto;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.repository.ProdutoRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

  @RequestMapping(value = "/incluir", method = RequestMethod.POST)
  public ModelAndView incluir(@ModelAttribute("produto") @Valid Produto p,
	  BindingResult bindingResult, RedirectAttributes redirectAttributes) {
    /*
    if (bindingResult.hasErrors() || bindingResult.hasFieldErrors()) {
      return new ModelAndView("produto/input").addObject("categorias", categoriaService.listar());
    }
    */
    p.setDtCadastro(new Date());
    produtoService.incluir(p);
    redirectAttributes.addFlashAttribute("msgSucesso", p.getNome());
    return new ModelAndView("redirect:/gerenciamento/produto");
  }
}
