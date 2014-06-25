package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.EstadoDAO;
import br.com.entity.Estado;

@Stateless
public class EstadoService {

	@Inject
	private EstadoDAO estadoDAO;
	
	public List<Estado> listaTodasEstados() {
		// TODO Auto-generated method stub
		return estadoDAO.recuperarTodos(Estado.class);
	}

	
}
