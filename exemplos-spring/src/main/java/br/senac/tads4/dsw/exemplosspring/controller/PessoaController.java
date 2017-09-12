/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import com.sun.javafx.event.RedirectedEvent;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

  @RequestMapping("/input")
  public ModelAndView formulario() {
    ModelAndView resultado = new ModelAndView("formulario");
    resultado.addObject("pessoa", new Pessoa());
    return resultado;
  }

  @RequestMapping("/input/{idPessoa}")
  public ModelAndView editar(@PathVariable("idPessoa") Integer id) {
    Pessoa p = new Pessoa();
    p.setNome("Ciclano da Silva");
    p.setIdade(29);
    p.setSexo(0);
    p.setPreferencias(new String[]{"Viagens", "Gastronomia"});
    p.setContato(true);
    ModelAndView resultado = new ModelAndView("formulario");
    resultado.addObject("pessoa", p);
    return resultado;
  }

  @RequestMapping(value = "/salvar", method = RequestMethod.POST)
  public ModelAndView salvar(@ModelAttribute Pessoa p,
	  RedirectAttributes redirectAttributes) {
    ModelAndView resultado
	    = new ModelAndView("redirect:/pessoa/resultado");

    /* Tecnica POST-REDIRECT-GET */
    redirectAttributes.addFlashAttribute("pessoa", p);
    return resultado;
  }

  @RequestMapping("/resultado")
  public ModelAndView resultado() {
    return new ModelAndView("resultado");
  }

}
