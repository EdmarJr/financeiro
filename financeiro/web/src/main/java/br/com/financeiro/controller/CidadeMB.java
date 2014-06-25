package br.com.financeiro.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Cidade;
import br.com.financeiro.service.CidadeService;

@ManagedBean
@ViewScoped
public class CidadeMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1895594455932942598L;

	@EJB
	private CidadeService cidadeService;
	
	private List<Cidade> cidades  = new ArrayList<Cidade>();
	
	private Cidade cidade = new Cidade();

	
	
	@PostConstruct
	private void init() {
		cidades = cidadeService.recuperarPorParametro(cidade);

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


	public List<Cidade> getCidades() {
		return cidades;
	}


	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}


	public Cidade getCidade() {
		return cidade;
	}


	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

	 
	
	
}
