/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.model;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author fernando.tsuda
 */
public class Usuario implements UserDetails {

  private String nomeCompleto;

  private String username;

  private String senha;

  private List<Papel> papeis;

  public Usuario() {
  }

  public Usuario(String nomeCompleto, String username, String senha, List<Papel> papeis) {
    this.nomeCompleto = nomeCompleto;
    this.username = username;
    this.senha = senha;
    this.papeis = papeis;
    System.out.println(username + ", " + senha);
  }

  @Override
  public Collection<Papel> getAuthorities() {
    return papeis;
  }

  @Override
  public String getPassword() {
    return senha;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getNomeCompleto() {
    return nomeCompleto;
  }

  public void setNomeCompleto(String nomeCompleto) {
    this.nomeCompleto = nomeCompleto;
  }

}
