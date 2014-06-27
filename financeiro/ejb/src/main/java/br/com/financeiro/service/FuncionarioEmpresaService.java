package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.FuncionarioEmpresaDAO;
import br.com.dao.GenericDAOImpl;
import br.com.entity.FuncionarioEmpresa;

@Stateless
public class FuncionarioEmpresaService extends Service<FuncionarioEmpresa> {

	@Inject
	private FuncionarioEmpresaDAO funcionarioEmpresaDAO;
	
	public List<FuncionarioEmpresa> obterFuncionarios() {
		return funcionarioEmpresaDAO.listarTodos(FuncionarioEmpresa.class);
	}
	
	@Override
	public GenericDAOImpl<FuncionarioEmpresa> getDAO() {
		return funcionarioEmpresaDAO;
	
	}

	
}
