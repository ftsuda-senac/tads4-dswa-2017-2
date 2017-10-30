/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.service;

import br.senac.tads4.dsw.tadsstore.spring.config.SecurityConfig;
import br.senac.tads4.dsw.tadsstore.spring.model.Papel;
import br.senac.tads4.dsw.tadsstore.spring.model.Usuario;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author fernando.tsuda
 */
@Service
public class UsuarioService implements UserDetailsService {
  
  private static final Map<String, Usuario> USUARIOS;
  
  static {
    USUARIOS = new LinkedHashMap<>();
    USUARIOS.put("fulano", 
	    new Usuario("Fulano da Silva", "fulano", 
		    SecurityConfig.passwordEncoder().encode("abcd1234"), 
		    Arrays.asList(new Papel("ROLE_FODINHA"))));
    USUARIOS.put("ciclano",
	    new Usuario("Ciclano de Souza", "ciclano", 
		    SecurityConfig.passwordEncoder().encode("abcd1234"), 
		    Arrays.asList(new Papel("ROLE_FODINHA"), new Papel("ROLE_FODAO"))));
    USUARIOS.put("beltrana",
	    new Usuario("Beltrana das Cruzes", "beltrana", 
		    SecurityConfig.passwordEncoder().encode("abcd1234"), 
		    Arrays.asList(new Papel("ROLE_FODINHA"), new Papel("ROLE_FODAO"), 
			    new Papel("ROLE_GOD"))));
  }

  @Override
  public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
    return USUARIOS.get(string);
  }
  
}
