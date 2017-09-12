/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author fernando.tsuda
 */
@Controller
public class ExemploController {
  
  @RequestMapping("/hello-world")
  public String saudar(
	  @RequestParam("nome") String nome,
	  @RequestParam(value = "idade", required = false) Integer idade,
	  Model modelo) {
    modelo.addAttribute("nome", nome);
    modelo.addAttribute("idade", idade);
    return "helloWorld";
  }
  
  @RequestMapping("/hello-world/{nome}")
  public ModelAndView saudar2(
	  @PathVariable("nome") String nome,
	  @RequestParam(value = "idade", required = false) Integer idade) {
    ModelAndView resultado = new ModelAndView("helloWorld");
    resultado.addObject("nome", nome);
    resultado.addObject("idade", idade);
    return resultado;
  }
  
}
