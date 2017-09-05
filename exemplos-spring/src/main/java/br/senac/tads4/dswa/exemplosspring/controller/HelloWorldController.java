/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dswa.exemplosspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author fernando.tsuda
 */
@Controller
public class HelloWorldController {

  @RequestMapping("/saudar")
  public String saudar(
	  @RequestParam("nome") String x,
	  @RequestParam("idade") int y,
	  Model modelo) {
    modelo.addAttribute("nome", x);
    modelo.addAttribute("idade", y);
    System.out.println("Nome: " + x + ", idade: " + y);
    return "helloWorld";
  }

}
