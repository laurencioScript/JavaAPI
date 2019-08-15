package br.pro.api.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.pro.api.dao.ItemVendaDao;
import br.pro.api.model.ItemVendaModel;


@Path("itemVenda")
public class ItemVendaService {
	
	@GET
	public String index() {

		ItemVendaDao dao = new ItemVendaDao();
		List<ItemVendaModel> itens =  dao.index();
		Gson gson= new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		String json = gson.toJson(itens);
		
		return json;
		
	}
	
	@POST
	public String store(String json) {
		
		Gson gson = new Gson();
		ItemVendaModel item = gson.fromJson(json,ItemVendaModel.class);
		
		ItemVendaDao dao = new ItemVendaDao();
		dao.store(item);
		
		String result = gson.toJson(item);
		
		return result;
		
	}
	
	@PUT
	public String update(String json) {
		
		Gson gson = new Gson();
		ItemVendaModel item = gson.fromJson(json,ItemVendaModel.class);
		
		ItemVendaDao dao = new ItemVendaDao();
		dao.update(item);
		
		String result = gson.toJson(item);
		
		return result;
	}
	
	@GET
	@Path("{codigo}")
	public String show(@PathParam("codigo") Long codigo) {
		
		ItemVendaDao dao = new ItemVendaDao();
		ItemVendaModel item =  dao.show(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(item);
		return json;
		
	}
	
	@DELETE
	@Path("{codigo}")
	public String delete(@PathParam("codigo") Long codigo) {
		
		Gson gson = new Gson();
		
		ItemVendaDao dao = new ItemVendaDao();
		ItemVendaModel item = dao.delete(codigo);
		
		String result = gson.toJson(item);
		
		return result;
		
	}
}
