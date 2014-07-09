package br.com.dao;

import java.util.List;

import br.com.entity.Empresa;
import br.com.entity.FuncaoEmpresa;

public interface FuncaoEmpresaDAO extends GenericDAO<FuncaoEmpresa>{

	public List<FuncaoEmpresa> getCargos();


	public FuncaoEmpresa pesquisaPorId(FuncaoEmpresa funcaoEmpresa);

	public List<FuncaoEmpresa> listaCargoPorLoja(Empresa empresa);
	
}
