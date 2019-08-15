package br.pro.api.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.pro.api.dao.ClienteDao;
import br.pro.api.model.ClienteModel;


@Path("cliente")
public class ClienteService {
	
	@GET
	public String index() {

		ClienteDao c = new ClienteDao();
		List<ClienteModel> clientes =  c.index();
		Gson gson = new Gson();
		
		String json = gson.toJson(clientes);
		
		return json;
		
	}
	
	@POST
	public String store(String json) {
		
		Gson gson = new Gson();
		ClienteModel cliente = gson.fromJson(json,ClienteModel.class);
		
		ClienteDao c = new ClienteDao();
		c.store(cliente);
		
		String result = gson.toJson(cliente);
		
		return result;
		
	}
	
	@PUT
	public String update(String json) {
		
		Gson gson = new Gson();
		ClienteModel cliente = gson.fromJson(json,ClienteModel.class);
		
		ClienteDao c = new ClienteDao();
		c.update(cliente);
		
		String result = gson.toJson(cliente);
		
		return result;
	}
	
	@GET
	@Path("{codigo}")
	public String show(@PathParam("codigo") Long codigo) {
		
		ClienteDao c = new ClienteDao();
		ClienteModel cliente =  c.show(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(cliente);
		return json;
		
	}
	
	@DELETE
	@Path("{codigo}")
	public String delete(@PathParam("codigo") Long codigo) {
		
		Gson gson = new Gson();
		
		ClienteDao c = new ClienteDao();
		ClienteModel cliente  = c.delete(codigo);
		
		String result = gson.toJson(cliente);
		
		return result;
		
	}
}
