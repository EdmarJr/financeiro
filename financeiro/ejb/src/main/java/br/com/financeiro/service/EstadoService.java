package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.EstadoDAO;
import br.com.entity.Estado;

@Stateless
public class EstadoService extends Service<Estado> {

	@Inject
	private EstadoDAO estadoDAO;
	
	public List<Estado> listaTodasEstados() {
		return obterTodos(Estado.class);
	}

	@Override
	public EstadoDAO getDAO() {
		return estadoDAO;
	}

	
}
