package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Empresa;
import br.com.entity.SetorEmpresa;
import br.com.financeiro.service.SetorService;

@ManagedBean
@ViewScoped
public class SetorMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869679819609073557L;

	@EJB
	private SetorService setorService;
	
	private List<SetorEmpresa> setores;
	
	private SetorEmpresa setor;
	
	Empresa empresa;
	
	
	@PostConstruct
	private void init() {
		if(setor==null)
			setor = new SetorEmpresa();
		
		if(empresa==null)
			empresa = new Empresa();

	}
	
	public void adiciona () {
		if(setor!=null){
			setor.setEmpresa(empresa);
			this.setorService.adiciona (this.setor);
		 this.setor= new SetorEmpresa();
		 listaSetores();
		}else{
			setor = new SetorEmpresa();
		}
	 }
	 
	public void listaSetores() {
		List<SetorEmpresa> lista = new ArrayList<SetorEmpresa>();
		lista = setorService.listaSetorEmpresaPorEmpresa(empresa);
		if(!lista.isEmpty()){
			setores = lista;
		}
	}
	
	public void remover() {
		setorService.remover(setor);
		listaSetores();
	}
	
	public SetorEmpresa getSetorEmpresa() {
		return setor;
	}
	public void setSetor(SetorEmpresa setor) {
		this.setor = setor;
	}


	public List<SetorEmpresa> getSetores() {
		return setores;
	}




	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public void setSetores(List<SetorEmpresa> setores) {
		this.setores = setores;
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
