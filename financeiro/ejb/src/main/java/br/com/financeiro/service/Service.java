package br.com.financeiro.service;

import java.util.List;

import br.com.dao.GenericDAO;

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
	
	public List<T> filtrar(T filtro) {
		return getDAO().filtrar(filtro);
	}
	
	public List<T> obterTodos(Class<T> clazz) {
		return getDAO().obterTodos(clazz);
	}

	public abstract GenericDAO<T> getDAO();

}
