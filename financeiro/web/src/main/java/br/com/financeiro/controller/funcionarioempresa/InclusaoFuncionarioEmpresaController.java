package br.com.financeiro.controller.funcionarioempresa;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import br.com.entity.FuncionarioEmpresa;

@Named
@ConversationScoped
public class InclusaoFuncionarioEmpresaController extends
		FuncionarioEmpresaController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void comandoIncluir(FuncionarioEmpresa entidade) {
		entidade.setSenha("teste");
		service.incluir(entidade);
	}

}
