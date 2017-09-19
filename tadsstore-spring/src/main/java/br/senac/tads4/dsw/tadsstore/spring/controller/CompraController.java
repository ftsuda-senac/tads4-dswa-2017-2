/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/compra")
@Scope("session")
public class CompraController {

  private List<Produto> carrinho = new ArrayList<Produto>();

  private ProdutoService servico = new ProdutoServiceFakeImpl();

  @RequestMapping("/adicionar/{id}")
  public ModelAndView adicionarProduto(
	  @PathVariable("id") long idProduto) {
    Produto p = servico.obter(idProduto);
    carrinho.add(p);
    return new ModelAndView("compra/carrinho");
  }
  
  public List<Produto> getCarrinho() {
    return carrinho;
  }

}
