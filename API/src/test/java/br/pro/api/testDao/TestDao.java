package br.pro.api.testDao;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.api.dao.ClienteDao;
import br.pro.api.model.ClienteModel;

public class TestDao {
	
	@Test
	@Ignore
	public void criar() {
		ClienteDao cliente = new ClienteDao();
		
		ClienteModel ze = new ClienteModel();
		ze.setCpf("39231581813-98");
		ze.setEmail("ze@gmail.com");
		ze.setNome("ze");
		ze.setTelefone("13 988153548");
		cliente.store(ze);
	}
	
	
}
