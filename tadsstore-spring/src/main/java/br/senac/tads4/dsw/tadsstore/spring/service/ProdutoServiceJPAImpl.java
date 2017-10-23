/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.spring.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author fernando.tsuda
 */
@Repository
public class ProdutoServiceJPAImpl implements ProdutoService {
  
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public List<Produto> listar(int offset, int quantidade) {
    Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens");
    return query.getResultList();
  }

  @Override
  public List<Produto> listarPorCategoria(Categoria categoria, 
	  int offset, int quantidade) {
    Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens "
	    + "INNER JOIN p.categorias c "
	    + "WHERE c.id = :idCat")
	    .setParameter("idCat", categoria.getId());
    return query.getResultList();
  }

  @Override
  public Produto obter(long idProduto) {
    Query query = entityManager.createQuery(
	    "SELECT DISTINCT p FROM Produto p "
	    + "LEFT JOIN FETCH p.categorias "
	    + "LEFT JOIN FETCH p.imagens "
	    + "WHERE p.id = :idProd")
	.setParameter("idProd", idProduto);
    return (Produto) query.getSingleResult();
  }

  @Override
  @Transactional
  public void incluir(Produto p) {
    entityManager.persist(p);
  }

  @Override
  @Transactional
  public void alterar(Produto p) {
    p = entityManager.merge(p);
  }

  @Override
  @Transactional
  public void remover(long idProduto) {
    Produto p = entityManager.find(Produto.class, idProduto);
    entityManager.remove(p);
  }

}
