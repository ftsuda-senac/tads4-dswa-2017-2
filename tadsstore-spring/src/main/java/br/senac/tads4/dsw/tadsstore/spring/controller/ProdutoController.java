/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {

  @Autowired
  private ProdutoService service;
  
  @Autowired
  private CategoriaService categoriaService;

  @RequestMapping
  public ModelAndView listar() {
    List<Produto> lista = service.listar(0, 100);
    return new ModelAndView("produto/lista")
	    .addObject("itens", lista)
	    .addObject("categorias", categoriaService.listar());
  }
  
  @RequestMapping("/filtro/{idCat}")
  public ModelAndView listarComFiltro(
	  @PathVariable("idCat") int idCategoria) {
    Categoria categoria = categoriaService.obter(idCategoria);
    List<Produto> lista = service.listarPorCategoria(categoria, 0, 100);
    return new ModelAndView("produto/lista")
	    .addObject("itens", lista)
	    .addObject("categorias", categoriaService.listar());
  }

  @RequestMapping("/{id}")
  public ModelAndView mostrarDetalhe(
	  @PathVariable("id") long id) {
    Produto p = service.obter(id);
    return new ModelAndView("produto/detalhe")
	    .addObject("produto", p);
  }

}
