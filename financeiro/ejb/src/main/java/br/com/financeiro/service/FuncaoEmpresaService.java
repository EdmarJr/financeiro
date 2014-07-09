package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.FuncaoEmpresaDAO;
import br.com.entity.Empresa;
import br.com.entity.FuncaoEmpresa;

@Stateless
public class FuncaoEmpresaService extends Service<FuncaoEmpresa>{

	
	@Inject
	private FuncaoEmpresaDAO funcaoEmpresaDAO;

	public void adiciona(FuncaoEmpresa funcaoEmpresa) {
		this.funcaoEmpresaDAO.atualizar(funcaoEmpresa);
	}

	public void remover(FuncaoEmpresa funcaoEmpresa) {
		this.funcaoEmpresaDAO.excluir(funcaoEmpresa);
	}

	
	public List<FuncaoEmpresa> getCargos() {
		return funcaoEmpresaDAO.getCargos();
	}


	public FuncaoEmpresa pesquisaPorId(FuncaoEmpresa funcaoEmpresa) {
		return funcaoEmpresaDAO.pesquisaPorId(funcaoEmpresa);
	}

	public List<FuncaoEmpresa> listaCargoPorLoja(Empresa empresa) {
		return funcaoEmpresaDAO.listaCargoPorLoja(empresa);
	}

	@Override
	public FuncaoEmpresaDAO getDAO() {
		return funcaoEmpresaDAO;
	}
}
