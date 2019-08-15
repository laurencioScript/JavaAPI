package br.pro.api.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemVendaModel extends GenericModel {
	
	@OneToOne
	@JoinColumn(nullable = false)
	private ProdutoModel produto;
	
	@Column(nullable = false)
	private Integer qtd;
	
	@Column(nullable = false,precision = 6,scale = 2)
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private VendaModel venda;

	public ProdutoModel getProduto() {
		return produto;
	}

	public void setProduto(ProdutoModel produto) {
		this.produto = produto;
	}

	public Integer getQtd() {
		return qtd;
	}

	public void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public VendaModel getVenda() {
		return venda;
	}

	public void setVenda(VendaModel venda) {
		this.venda = venda;
	}
	
	
}
