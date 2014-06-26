package br.com.financeiro.controller.funcionarioempresa;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.entity.FuncionarioEmpresa;
import br.com.financeiro.service.FuncionarioEmpresaService;

@Named
@ConversationScoped
public abstract class FuncionarioEmpresaController implements Serializable{
	
	@EJB
	private FuncionarioEmpresaService service;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ConsultaFuncionarioEmpresaController consultaFuncionarioEmpresaController;
	
	@Inject
	private Conversation conversation;
	
	private FuncionarioEmpresa funcionarioEmpresa;
	
	
	
}
