package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.CidadeDAO;
import br.com.entity.Cidade;
import br.com.entity.Estado;

@Stateless
public class CidadeService extends Service<Cidade> {

	@Inject
	private CidadeDAO cidadeDAO;
	
	public List<Cidade> recuperarPorParametro(Cidade cidade) {
		return cidadeDAO.recuperarPorParametro(cidade);
	}
	
	public List<Cidade> obterCidadesPorEstado(Estado estado) {
		Cidade filtro = new Cidade();
		filtro.setEstado(estado);
		return filtrar(filtro);
	}
	
	@Override
	public CidadeDAO getDAO() {
		return cidadeDAO;
	}

	
}
