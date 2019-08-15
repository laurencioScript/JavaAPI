package br.pro.api.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class VendaModel extends GenericModel {

	@JoinColumn(nullable = false)
	@ManyToOne
	private ClienteModel cliente;
	
	@Temporal(TemporalType.DATE)
	private Date dataVenda;
	
	@Column(nullable = false,precision = 9,scale = 2)
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
