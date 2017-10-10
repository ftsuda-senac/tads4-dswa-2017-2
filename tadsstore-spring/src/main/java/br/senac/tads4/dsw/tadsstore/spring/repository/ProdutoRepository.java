/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.repository;

import java.util.List;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fernando.tsuda
 */
@Repository
public class ProdutoRepository {

  @PersistenceContext
  private EntityManager entityManager;

  public List<Produto> listar() {
    Query query = entityManager.createQuery("SELECT p FROM Produto p");
    return query.getResultList();
  }

}
