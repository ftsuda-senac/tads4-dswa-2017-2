/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.exemplosspring.controller;

/**
 *
 * @author fernando.tsuda
 */
public class Pessoa {
  
  private String nome;
  
  private int idade;
  
  private int sexo;
  
  private String[] preferencias;
  
  private boolean contato;

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public int getSexo() {
    return sexo;
  }

  public void setSexo(int sexo) {
    this.sexo = sexo;
  }

  public String[] getPreferencias() {
    return preferencias;
  }

  public void setPreferencias(String[] preferencias) {
    this.preferencias = preferencias;
  }

  public boolean isContato() {
    return contato;
  }

  public void setContato(boolean contato) {
    this.contato = contato;
  }
  
}
