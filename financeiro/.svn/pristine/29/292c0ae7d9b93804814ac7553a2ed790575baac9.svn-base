package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Empresa;
import br.com.financeiro.service.EmpresaService;

@ManagedBean
@ViewScoped
public class EmpresaMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1895594455932942598L;

	@EJB
	private EmpresaService empresaService;
	
	private List<Empresa> empresas  = new ArrayList<Empresa>();
	
	private Empresa empresa = new Empresa();
	
	
	@PostConstruct
	private void init() {
		empresas = empresaService.getEmpresas();

	}
	
	public void adiciona() {
		if(empresa!=null){
			this.empresaService.adiciona (this.empresa);
		 this.empresa= new Empresa();
		}else{
			empresa = new Empresa();
		}
	 }
	 
	public void remover() {
		empresaService.remover(empresa);
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public List<Empresa> getEmpresas() {
		return empresas;
	}


	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
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
	 
	

	 
	
	
}
