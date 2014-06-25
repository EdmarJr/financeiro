package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Estado;
import br.com.financeiro.service.EstadoService;

@ManagedBean
@ViewScoped
public class EstadoMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1895594455932942598L;

	@EJB
	private EstadoService estadoService;
	
	private List<Estado> estados  = new ArrayList<Estado>();
	
	private Estado estado = new Estado();
	
	
	@PostConstruct
	private void init() {
		estados = estadoService.listaTodasEstados();

	}


	@Override
	public void adiciona() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void listar() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remover() {
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


	public List<Estado> getEstados() {
		return estados;
	}


	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}


	public Estado getEstado() {
		return estado;
	}


	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

	 
	
	
}
