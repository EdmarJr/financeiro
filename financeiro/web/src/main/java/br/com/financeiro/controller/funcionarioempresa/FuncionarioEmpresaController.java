package br.com.financeiro.controller.funcionarioempresa;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.entity.FuncionarioEmpresa;
import br.com.financeiro.service.FuncionarioEmpresaService;


public abstract class FuncionarioEmpresaController implements Serializable{
	
	@EJB
	protected FuncionarioEmpresaService service;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ConsultaFuncionarioEmpresaController consultaFuncionarioEmpresaController;
	
	@Inject
	protected Conversation conversation;
	
	private FuncionarioEmpresa funcionarioEmpresa;
	
	@PostConstruct
	public void inicializar() {
		funcionarioEmpresa = new FuncionarioEmpresa();
	}

	public FuncionarioEmpresa getFuncionarioEmpresa() {
		return funcionarioEmpresa;
	}

	public void setFuncionarioEmpresa(FuncionarioEmpresa funcionarioEmpresa) {
		this.funcionarioEmpresa = funcionarioEmpresa;
	}
	
	
	
	
	
}
