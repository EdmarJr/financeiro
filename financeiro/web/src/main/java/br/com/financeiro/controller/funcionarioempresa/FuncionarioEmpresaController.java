package br.com.financeiro.controller.funcionarioempresa;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Estado;
import br.com.entity.FuncionarioEmpresa;
import br.com.financeiro.service.CidadeService;
import br.com.financeiro.service.FuncionarioEmpresaService;
import br.com.financeiro.vo.ParametrosDisponiveisInclusaoFuncionarioVO;

@ManagedBean
@ViewScoped
public class FuncionarioEmpresaController implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * SERVIÇOS UTILIZADOS PELO O CONTROLLER
	 */
	@EJB
	protected FuncionarioEmpresaService service;
	@EJB
	protected CidadeService cidadeService;

	/**
	 * PARAMETROS DISPONIVEIS INCLUSAO
	 */
	private ParametrosDisponiveisInclusaoFuncionarioVO parametros;

	private FuncionarioEmpresa funcionarioEmpresa;
	private List<FuncionarioEmpresa> funcionariosCadastrados;

	@PostConstruct
	public void inicializar() {
		inicializarFuncionario();
		setParametros(service.obterParametrosDisponiveisInclusaoFuncionario());
		carregarFuncionariosCadastrados();
	}

	private void inicializarFuncionario() {
		setFuncionarioEmpresa(new FuncionarioEmpresa());
	}

	private void carregarFuncionariosCadastrados() {
		setFuncionariosCadastrados(service.obterFuncionariosPorUsuarioLogado());
	}

	public void comandoSalvar(FuncionarioEmpresa entidade) {
		entidade.setSenha("teste");
		if (entidade.getId() == null) {
			service.incluir(entidade);
		} else {
			service.alterar(entidade);
		}
		depoisDeTodoComando();
	}

	private void depoisDeTodoComando() {
//		RequestContext.getCurrentInstance().execute("afterComando()");
		setFuncionarioEmpresa(new FuncionarioEmpresa());
		carregarFuncionariosCadastrados();
	}

	public void comandoExcluir(FuncionarioEmpresa entidade) {
		service.excluir(entidade);
		depoisDeTodoComando();
	}

	public void comandoAlterar(
			FuncionarioEmpresa entidadeClicada) {
		onChangeSelectEstado(entidadeClicada.getEstado());
		setFuncionarioEmpresa(entidadeClicada);
	}

	public void onChangeSelectEstado(Estado estado) {
		if (estado != null) {
			getParametros().setCidades(
					cidadeService.obterCidadesPorEstado(estado));
		}
	}

	public FuncionarioEmpresa getFuncionarioEmpresa() {
		return funcionarioEmpresa;
	}

	public void setFuncionarioEmpresa(FuncionarioEmpresa funcionarioEmpresa) {
		this.funcionarioEmpresa = funcionarioEmpresa;
	}

	public ParametrosDisponiveisInclusaoFuncionarioVO getParametros() {
		return parametros;
	}

	public void setParametros(
			ParametrosDisponiveisInclusaoFuncionarioVO parametros) {
		this.parametros = parametros;
	}

	public List<FuncionarioEmpresa> getFuncionariosCadastrados() {
		return funcionariosCadastrados;
	}

	public void setFuncionariosCadastrados(
			List<FuncionarioEmpresa> funcionariosCadastrados) {
		this.funcionariosCadastrados = funcionariosCadastrados;
	}

}
