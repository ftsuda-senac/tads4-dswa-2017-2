/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView input() {
    return new ModelAndView("upload");
  }

  @RequestMapping(method = RequestMethod.POST)
  public ModelAndView salvarArquivo(
	  @RequestParam("arquivo") MultipartFile file,
	  RedirectAttributes redirectAttributes) {
    if (file.isEmpty()) {
      redirectAttributes.addFlashAttribute("mensagemErro",
	      "Erro ao enviar arquivo");
      return new ModelAndView("redirect:/upload");
    }

    try {
      byte[] bytes = file.getBytes();
      Path destino = Paths.get("C:/desenv/arquivos/"
	      + file.getOriginalFilename());
      Files.write(destino, bytes);
    } catch (IOException ex) {
      redirectAttributes.addFlashAttribute("mensagemErro",
	      ex.getCause().getMessage());
      return new ModelAndView("redirect:/upload");
    }
    redirectAttributes.addFlashAttribute("mensagem", "Arquivo " + file.getOriginalFilename() + " salvo com sucesso.");
    return new ModelAndView("redirect:/upload");
  }

}
