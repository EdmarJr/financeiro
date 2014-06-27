package br.com.financeiro.service;

import br.com.dao.GenericDAOImpl;

public abstract class Service<T> {

	public void incluir(T entidade) {
		getDAO().incluir(entidade);
	}

	public void alterar(T entidade) {
		getDAO().atualizar(entidade);
	}

	public void excluir(T entidade) {
		getDAO().excluir(entidade);
	}

	public abstract GenericDAOImpl<T> getDAO();

}
