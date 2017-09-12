/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

import java.math.BigDecimal;

/**
 *
 * @author fernando.tsuda
 */
public class Produto {
  
  private String nome;
  
  private BigDecimal valor;
  
  private String descricao;
  
  public Produto() {
    
  }

  public Produto(String nome, BigDecimal valor, String descricao) {
    this.nome = nome;
    this.valor = valor;
    this.descricao = descricao;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
}
