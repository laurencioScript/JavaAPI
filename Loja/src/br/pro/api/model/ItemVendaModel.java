package br.pro.api.model;

import java.math.BigDecimal;

public class ItemVendaModel extends GenericModel {
	
	private ProdutoModel produto;
	
	private Integer qtd;
	
	private BigDecimal valor;
	
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
