package br.pro.api.test;

import com.google.gson.Gson;

import br.pro.api.dao.ClienteDao;
import br.pro.api.dao.ProdutoDao;
import br.pro.api.model.ClienteModel;
import br.pro.api.model.ProdutoModel;

public class clienteTest {

	
	
	
	public static void main(String[] args) {
		

		ProdutoDao dao = new ProdutoDao("produto");
		//ClienteDao c = new ClienteDao();
		String clientes = dao.index();
		Gson g = new Gson();
		
		ProdutoModel[] vetor = g.fromJson(clientes,ProdutoModel[].class);
		
		System.out.print(vetor.length);
		
		//String valor = Integer.toString(cliente.length);
		//System.out.print(valor);
		
		//ClienteModel cliente = dao.show(1L);
		//System.out.print(cliente.getNome());
		
		//ClienteModel cliente = new ClienteModel();
		//cliente.setCodigo(13L);
		//cliente.setNome("Giovanna");
		//cliente.setCpf("39231586645");
		//cliente.setTelefone("98815354878");
		//cliente.setEmail("bomfim@gmail.com");
		
	    
		
	}
}
