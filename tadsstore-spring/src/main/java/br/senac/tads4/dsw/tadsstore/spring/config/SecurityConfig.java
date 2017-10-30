/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author fernando.tsuda
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public static BCryptPasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public PasswordEncoder bCryptPasswordEncoder() {
    return passwordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
	    .antMatchers("/gerenciamento/**").hasRole("FODAO")
	    .antMatchers("/**").authenticated()
	  .and()
	    .formLogin()
	      .loginPage("/login").usernameParameter("username")
	      .passwordParameter("senha")
	      .defaultSuccessUrl("/produto").permitAll()
	  .and()
	    .logout()
	      .logoutUrl("/logout").logoutSuccessUrl("/login?logout")
	      .invalidateHttpSession(true).deleteCookies("JSESSIONID");
  }
}
