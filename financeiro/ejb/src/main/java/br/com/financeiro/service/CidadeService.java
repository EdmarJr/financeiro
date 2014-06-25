package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.CidadeDAO;
import br.com.entity.Cidade;

@Stateless
public class CidadeService {

	@Inject
	private CidadeDAO cidadeDAO;
	
	public List<Cidade> recuperarPorParametro(Cidade cidade) {
		// TODO Auto-generated method stub
		return cidadeDAO.recuperarPorParametro(cidade);
	}

	
}
