/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dswa.exemplosspring.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author fernando.tsuda
 */
@Controller
public class ListaController {
  
  @RequestMapping("/lista")
  public String listar(Model modelo) {
    List<Produto> produtos = new ArrayList<>();
    produtos.add(new Produto("prod 1", new BigDecimal(9.99), "prod 1 descr"));
    produtos.add(new Produto("prod 2", new BigDecimal(3.99), "prod 2 descr"));
    produtos.add(new Produto("prod 3", new BigDecimal(5.99), "prod 3 descr"));
    produtos.add(new Produto("prod 4", new BigDecimal(8.99), "prod 4 descr"));
    
    modelo.addAttribute("produtos", produtos);
    modelo.addAttribute("timestamp", System.currentTimeMillis());
    return "lista";
  }
  
}
