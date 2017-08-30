package br.senac.tads4.dswa.tadsstore.springmvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class TadsstoreSpringmvcApplication extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(TadsstoreSpringmvcApplication.class);
  }

  public static void main(String[] args) {
    SpringApplication.run(TadsstoreSpringmvcApplication.class, args);
  }
}