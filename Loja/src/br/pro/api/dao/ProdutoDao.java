package br.pro.api.dao;

import br.pro.api.model.ProdutoModel;

public class ProdutoDao extends GenericDao<ProdutoModel> {

	public ProdutoDao(String url) {
		super(url);
	}
}
