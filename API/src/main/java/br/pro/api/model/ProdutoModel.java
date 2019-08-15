package br.pro.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ProdutoModel extends GenericModel {
	
	@Column(length = 100,nullable = false)
	private String nome;
	
	@Column(length = 200,nullable = false)
	private String descricao;
	
	@Column(nullable = false,precision = 6,scale = 2)
	private BigDecimal preco;
	
	@Column(nullable = false)
	private Integer qtd;
	
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
	public Integer getQtd() {
		return qtd;
	}
	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	
}
