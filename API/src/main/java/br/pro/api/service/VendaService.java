package br.pro.api.service;

import java.util.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.pro.api.dao.VendaDao;
import br.pro.api.model.VendaModel;

@Path("venda")
public class VendaService {

	@GET
	public String index() {

		VendaDao dao = new VendaDao();
		List<VendaModel> venda =  dao.index();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		
		String json = gson.toJson(venda);
		
		return json;
		
	}
	
	@POST
	public String store(String json) {
		
		Gson gson = new Gson();
		
		VendaModel venda = gson.fromJson(json,VendaModel.class);
		venda.setDataVenda(new Date());
		VendaDao dao = new VendaDao();
		dao.store(venda);
		
		return venda.getCodigo().toString();
		
	}
	
	@PUT
	public String update(String json) {
		
		Gson gson = new Gson();
		VendaModel venda = gson.fromJson(json,VendaModel.class);
		
		VendaDao dao = new VendaDao();
		dao.update(venda);
		
		String result = gson.toJson(venda);
		
		return result;
	}
	
	@GET
	@Path("{codigo}")
	public String show(@PathParam("codigo") Long codigo) {
		
		VendaDao dao = new VendaDao();
		VendaModel venda =  dao.show(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(venda);
		return json;
		
	}
	
	@DELETE
	@Path("{codigo}")
	public String delete(@PathParam("codigo") Long codigo) {
		
		Gson gson = new Gson();
		
		VendaDao dao = new VendaDao();
		VendaModel venda = dao.delete(codigo);
		
		String result = gson.toJson(venda);
		
		return result;
		
	}
}
