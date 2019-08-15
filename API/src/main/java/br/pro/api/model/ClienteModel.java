package br.pro.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class ClienteModel extends GenericModel {
	
	@Column(length = 100,nullable = false)
	private String nome;
	
	@Column(length = 20,nullable = false)
	private String telefone;
	
	@Column(length = 100)
	private String email;
	
	@Column(length = 15,nullable = false)
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
