package br.com.financeiro.controller.funcionarioempresa;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped
public class ConsultaFuncionarioEmpresaController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private Conversation conversation;
	
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
}
