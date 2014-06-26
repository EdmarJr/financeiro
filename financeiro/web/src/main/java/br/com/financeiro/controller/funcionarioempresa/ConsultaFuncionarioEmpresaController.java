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
public class ConsultaFuncionarioEmpresaController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Conversation conversation;
	@EJB
	private FuncionarioEmpresaService service;
	
	private FuncionarioEmpresa filtro;

	public String comandoIncluir() {
		conversation.begin();
		return "";
	}
	public String comandoAlterar() {
		conversation.begin();
		return "";
	}
	public String comandoExcluir() {
		conversation.begin();
		return "";
	}

	public void comandoFiltrar() {
		service.obterFuncionarios();
	}

	public FuncionarioEmpresa getFiltro() {
		return filtro;
	}

	public void setFiltro(FuncionarioEmpresa filtro) {
		this.filtro = filtro;
	}
}
