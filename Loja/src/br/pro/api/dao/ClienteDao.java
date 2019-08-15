package br.pro.api.dao;

import br.pro.api.model.ClienteModel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import com.google.gson.Gson;

public class ClienteDao extends GenericDao<ClienteModel> {

	public ClienteDao(String parms) {
		super(parms);
	}
	
}
