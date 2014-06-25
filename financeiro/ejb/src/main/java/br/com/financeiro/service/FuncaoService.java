package br.com.financeiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.dao.FuncaoDAO;
import br.com.entity.Empresa;
import br.com.entity.FuncaoEmpresa;

@Stateless
public class FuncaoService {

	
	@Inject
	private FuncaoDAO funcaoDAO;

	public void adiciona(FuncaoEmpresa funcaoEmpresa) {
		this.funcaoDAO.atualizar(funcaoEmpresa);
	}

	public void remover(FuncaoEmpresa funcaoEmpresa) {
		this.funcaoDAO.excluir(funcaoEmpresa);
	}

	
	public List<FuncaoEmpresa> getCargos() {
		return funcaoDAO.getCargos();
	}


	public FuncaoEmpresa pesquisaPorId(FuncaoEmpresa funcaoEmpresa) {
		return funcaoDAO.pesquisaPorId(funcaoEmpresa);
	}

	public List<FuncaoEmpresa> listaCargoPorLoja(Empresa empresa) {
		return funcaoDAO.listaCargoPorLoja(empresa);
	}
}
