package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.FuncionarioEmpresaDAO;
import br.com.entity.FuncionarioEmpresa;

@Stateless
public class FuncionarioEmpresaService {

	@Inject
	private FuncionarioEmpresaDAO funcionarioEmpresaDAO;
	
	public List<FuncionarioEmpresa> obterFuncionarios() {
		return funcionarioEmpresaDAO.listarTodos(FuncionarioEmpresa.class);
	}

	
}
