package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Empresa;
import br.com.entity.FuncaoEmpresa;
import br.com.financeiro.service.EmpresaService;
import br.com.financeiro.service.FuncaoService;

@ManagedBean
@ViewScoped
public class FuncaoMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = -445431629703546070L;
	@EJB
	private FuncaoService funcaoService;
	@EJB
	private EmpresaService empresaService;
	
	
	
	
	private List<FuncaoEmpresa> funcaoes  = new ArrayList<FuncaoEmpresa>();
	private List<Empresa> empresas  = new ArrayList<Empresa>();
	private FuncaoEmpresa funcaoEmpresa;
	
	Empresa empresa ;
	
	
	@PostConstruct
	private void init() {
		if(empresa==null)
			empresa = new Empresa();
		
		if(funcaoEmpresa==null)
			funcaoEmpresa = new FuncaoEmpresa();

	}
	
	public void adiciona () {
		if(funcaoEmpresa!=null){
			this.funcaoService.adiciona (this.funcaoEmpresa);
		 this.funcaoEmpresa= new FuncaoEmpresa();
		 listaCargoes();
		}else{
			funcaoEmpresa = new FuncaoEmpresa();
		}
	 }
	 
	public void listaCargoes() {
		List<FuncaoEmpresa> lista = new ArrayList<FuncaoEmpresa>();
		lista = funcaoService.listaCargoPorLoja(empresa);
		if(!lista.isEmpty()){
			getFuncaoes().addAll(lista);
		}
	}
	
	public void remover() {
		funcaoService.remover(funcaoEmpresa);
		listaCargoes();
	}

	public List<FuncaoEmpresa> getFuncaoes() {
		return funcaoes;
	}

	public void setFuncaoes(List<FuncaoEmpresa> funcaoes) {
		this.funcaoes = funcaoes;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public FuncaoEmpresa getFuncaoEmpresa() {
		return funcaoEmpresa;
	}

	public void setFuncaoEmpresa(FuncaoEmpresa funcaoEmpresa) {
		this.funcaoEmpresa = funcaoEmpresa;
	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	


	
	 
	

	 
	
	
}
