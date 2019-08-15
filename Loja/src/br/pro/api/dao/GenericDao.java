package br.pro.api.dao;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import com.google.gson.Gson;

import br.pro.api.model.ClienteModel;

public class GenericDao<Entidade> {
	
	private String url;
	private Class<Entidade> classe;
	
	public GenericDao(String url) {
		this.url = "http://localhost:8080/API/rest/"+url;
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	
	public void store(Entidade entidade) {
		
		
		Client c = ClientBuilder.newClient();
		WebTarget caminho =  c.target(this.url);
		
		Gson g = new Gson();
		
		String json = g.toJson(entidade);
		
		Response result = caminho.request().post(Entity.json(json));
		
		
	}
	
	public  String index(){
		
		
		Client c = ClientBuilder.newClient();
		WebTarget caminho =  c.target(this.url);
		
		Gson g = new Gson();
		String json = caminho.request().get(String.class);
		
		//Entidade[] vetor = g.fromJson(json,this.vetor.class);
		
		return json;
		
	}
	
	
	
	public Entidade show(Long codigo){
		
		String url = this.url+"/";
		String cod =  codigo.toString();
		url = url+cod;
		
		Client c = ClientBuilder.newClient();
		WebTarget caminho =  c.target(url);
		
		Gson g = new Gson();
		String json = caminho.request().get(String.class);
		
		Entidade vetor = g.fromJson(json, this.classe);
		
		return vetor;
		
	}
	
	public void delete(Long codigo) {
	
		String url = this.url+"/";
		String cod =  codigo.toString();
		url = url+cod;
		System.out.print(url);
		Client c = ClientBuilder.newClient();
		WebTarget caminho =  c.target(url);
		
		Gson g = new Gson();
		
		caminho.request().delete(String.class);
		
	}
	
	public void update(Entidade entidade) {
	
		
		Client c = ClientBuilder.newClient();
		WebTarget caminho =  c.target(this.url);
		
		Gson g = new Gson();
		
		String json = g.toJson(entidade);
		
		caminho.request().put(Entity.json(json));
		
	}
	
}
