package br.pro.api.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.pro.api.dao.ProdutoDao;
import br.pro.api.model.ProdutoModel;


@Path("produto")
public class ProdutoService {

	@GET
	public String index() {

		ProdutoDao dao = new ProdutoDao();
		List<ProdutoModel> itens =  dao.index();
		Gson gson = new Gson();
		
		String json = gson.toJson(itens);
		
		return json;
		
	}
	
	@POST
	public String store(String json) {
		
		Gson gson = new Gson();
		ProdutoModel produto = gson.fromJson(json,ProdutoModel.class);
		
		ProdutoDao dao = new ProdutoDao();
		dao.store(produto);
		
		String result = gson.toJson(produto);
		
		return result;
		
	}
	
	@PUT
	public String update(String json) {
		
		Gson gson = new Gson();
		ProdutoModel produto = gson.fromJson(json,ProdutoModel.class);
		
		ProdutoDao dao = new ProdutoDao();
		dao.update(produto);
		
		String result = gson.toJson(produto);
		
		return result;
	}
	
	@GET
	@Path("{codigo}")
	public String show(@PathParam("codigo") Long codigo) {
		
		ProdutoDao dao = new ProdutoDao();
		ProdutoModel produto =  dao.show(codigo);
		Gson gson = new Gson();
		String json = gson.toJson(produto);
		return json;
		
	}
	
	@DELETE
	@Path("{codigo}")
	public String delete(@PathParam("codigo") Long codigo) {
		
		Gson gson = new Gson();
		
		ProdutoDao dao = new ProdutoDao();
		ProdutoModel produto = dao.delete(codigo);
		
		String result = gson.toJson(produto);
		
		return result;
		
	}
}
