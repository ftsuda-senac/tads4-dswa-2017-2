/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fernando.tsuda
 */
// https://docs.spring.io/spring-data/jpa/docs/1.11.8.RELEASE/reference/html/#repositories.core-concepts
@Repository
public interface ProdutoRepository 
	extends CrudRepository<Produto, Long> {

}
