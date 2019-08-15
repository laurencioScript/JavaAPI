package br.pro.api.model;

import java.math.BigDecimal;
import java.util.Date;


public class VendaModel extends GenericModel {

	private ClienteModel cliente;
	
	private Date dataVenda;
	
	private BigDecimal precoTotal;

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}
	
	
	
}
