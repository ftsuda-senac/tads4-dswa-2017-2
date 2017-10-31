/*
 * The MIT License
 *
 * Copyright 2016 fernando.tsuda.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.senac.tads4.dsw.tadsstore.common.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 *
 * @author fernando.tsuda
 */
@Entity
@Table(name = "TB_PRODUTO")
public class Produto implements Serializable {

  @Id
  @Column(name = "ID_PRODUTO")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "NM_PRODUTO", length = 100, nullable = false)
  @NotNull(message = "{produto.nome.erro}")
  private String nome;

  @Column(name = "DS_PRODUTO", length = 1000, nullable = false)
  @NotNull(message = "{produto.descricao.erro}")
  private String descricao;

  @Column(name = "VL_PRODUTO", precision = 6, scale = 2, nullable = false)
  @Digits(integer = 6, fraction = 2, message = "{produto.preco.erro}")
  private BigDecimal preco;

  @Column(name = "DT_CADASTRO", nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Date dtCadastro;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "TB_PRODUTO_CATEGORIA",
	  joinColumns = {
	    @JoinColumn(name = "ID_PRODUTO")
	  },
	  inverseJoinColumns = {
	    @JoinColumn(name = "ID_CATEGORIA")
	  })
  private Set<Categoria> categorias;

  @OneToMany(mappedBy = "produto", fetch = FetchType.LAZY,
	  cascade = {CascadeType.REMOVE})

  private Set<ImagemProduto> imagens;

  @Transient
  private Set<Integer> idsCategorias;

  @Transient
  private String observacoes;

  //private List<ItemCompra> itensCompra;
  public Produto() {

  }

  public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.dtCadastro = dtCadastro;
  }

  public Produto(Long id, String nome, String descricao, BigDecimal preco, Date dtCadastro, Set<ImagemProduto> imagens, Set<Categoria> categorias) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.preco = preco;
    this.dtCadastro = dtCadastro;
    this.imagens = imagens;
    this.categorias = categorias;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }

  public Set<Categoria> getCategorias() {
    return categorias;
  }

  public void setCategorias(Set<Categoria> categorias) {
    this.categorias = categorias;
  }

  public Set<ImagemProduto> getImagens() {
    return imagens;
  }

  public void setImagens(Set<ImagemProduto> imagens) {
    this.imagens = imagens;
  }
//
//  public List<ItemCompra> getItensCompra() {
//    return itensCompra;
//  }
//
//  public void setItensCompra(List<ItemCompra> itensCompra) {
//    this.itensCompra = itensCompra;
//  }

  public Set<Integer> getIdsCategorias() {
    return idsCategorias;
  }

  public void setIdsCategorias(Set<Integer> idsCategorias) {
    this.idsCategorias = idsCategorias;
  }

  @Override
  public String toString() {
    return "Produto{" + "id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", dtCadastro=" + dtCadastro + ", categorias=" + categorias + ", imagens=" + imagens + '}';
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + Objects.hashCode(this.id);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Produto other = (Produto) obj;
    if (!Objects.equals(this.id, other.id)) {
      return false;
    }
    return true;
  }

}
