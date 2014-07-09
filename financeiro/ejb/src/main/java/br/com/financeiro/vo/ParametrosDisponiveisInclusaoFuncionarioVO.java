package br.com.financeiro.vo;

import java.util.List;

import br.com.entity.Cidade;
import br.com.entity.Empresa;
import br.com.entity.Estado;
import br.com.entity.FuncaoEmpresa;
import br.com.entity.SetorEmpresa;

public class ParametrosDisponiveisInclusaoFuncionarioVO {
	private List<Cidade> cidades;
	private List<Estado> estados;
	private List<FuncaoEmpresa> funcoes;
	private List<SetorEmpresa> setores;
	private List<Empresa> empresas;

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public List<FuncaoEmpresa> getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(List<FuncaoEmpresa> funcoes) {
		this.funcoes = funcoes;
	}

	public List<SetorEmpresa> getSetores() {
		return setores;
	}

	public void setSetores(List<SetorEmpresa> setores) {
		this.setores = setores;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

}
