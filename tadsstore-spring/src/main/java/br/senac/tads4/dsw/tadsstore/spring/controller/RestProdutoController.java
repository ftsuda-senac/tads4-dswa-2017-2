/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.CategoriaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fernando.tsuda
 */
@RestController
@RequestMapping("/rest/produto")
public class RestProdutoController {

  @Autowired
  private ProdutoService service;

  @Autowired
  private CategoriaService categoriaService;

  @RequestMapping(method = RequestMethod.GET)
  public List<Produto> listar() {
    List<Produto> lista = service.listar(0, 100);
    return lista;
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @CrossOrigin(origins = "*")
  public Produto mostrarDetalhe(@PathVariable("id") long id) {
    Produto p = service.obter(id);
    return p;
  }

  
  /*
  Exemplo JSON para POST:
  {
  "nome": "Teste REST",
  "descricao": "produto adicionado via REST",
  "preco": 123.45,
  "idsCategorias": [1,2, 3] 
  }
  */
  
  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<Produto> salvar(@RequestBody Produto p) {
    if (p != null) {

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
      service.incluir(p);
      return new ResponseEntity<Produto>(HttpStatus.CREATED);
    }
    return new ResponseEntity<Produto>(HttpStatus.BAD_REQUEST);
  }

}
