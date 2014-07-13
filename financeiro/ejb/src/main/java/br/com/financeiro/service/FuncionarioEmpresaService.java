package br.com.financeiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.FuncionarioEmpresaDAO;
import br.com.entity.Cidade;
import br.com.entity.Empresa;
import br.com.entity.Estado;
import br.com.entity.FuncaoEmpresa;
import br.com.entity.FuncionarioEmpresa;
import br.com.entity.SetorEmpresa;
import br.com.entity.Usuario;
import br.com.financeiro.vo.ParametrosDisponiveisInclusaoFuncionarioVO;

@Stateless
public class FuncionarioEmpresaService extends Service<FuncionarioEmpresa> {

	@Inject
	private FuncionarioEmpresaDAO funcionarioEmpresaDAO;
	@EJB
	private CidadeService cidadeService;
	@EJB
	private UsuarioService usuarioService;
	@EJB
	private EstadoService estadoService;
	@EJB
	private SetorService setorService;
	@EJB
	private EmpresaService empresaService;
	@EJB
	private FuncaoEmpresaService funcaoEmpresaService;

	public List<FuncionarioEmpresa> obterFuncionarios() {
		return funcionarioEmpresaDAO.listarTodos(FuncionarioEmpresa.class);
	}

	@Override
	public FuncionarioEmpresaDAO getDAO() {
		return funcionarioEmpresaDAO;

	}

	public FuncionarioEmpresa obterFuncionarioPorEmailEmpresa(Empresa empresa,String email) {
		return getDAO().obterFuncionarioPorEmailEmpresa(empresa, email);
	}

	public Boolean seExisteFuncionarioComMesmoEmail(
			FuncionarioEmpresa funcionario) {
		FuncionarioEmpresa funcionarioRetorno = obterFuncionarioPorEmailEmpresa(funcionario.getEmpresa(),funcionario
				.getEmail());
		if ((funcionarioRetorno != null && funcionario.getId() == null)
				|| (funcionarioRetorno != null && funcionario.getId() != null && !funcionarioRetorno
						.getId().toString()
						.equals(funcionarioRetorno.getId().toString()))) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public void incluir(FuncionarioEmpresa entidade) {
		if(!seExisteFuncionarioComMesmoEmail(entidade)) {
			getDAO().incluir(entidade);
		}
	}

	public ParametrosDisponiveisInclusaoFuncionarioVO obterParametrosDisponiveisInclusaoFuncionario() {
		ParametrosDisponiveisInclusaoFuncionarioVO parametros = new ParametrosDisponiveisInclusaoFuncionarioVO();
		parametros.setCidades(new ArrayList<Cidade>());
		parametros.setEmpresas(empresaService
				.obterEmpresasDisponiveisInclusao());
		parametros.setEstados(estadoService.obterTodos(Estado.class));
		parametros.setFuncoes(funcaoEmpresaService
				.obterTodos(FuncaoEmpresa.class));
		parametros.setSetores(setorService.obterTodos(SetorEmpresa.class));
		return parametros;
	}

	public List<FuncionarioEmpresa> obterFuncionariosPorUsuarioLogado() {
		FuncionarioEmpresa filtro = new FuncionarioEmpresa();
		Usuario usuario = usuarioService.obterUsuarioLogado();
		if (usuario instanceof FuncionarioEmpresa) {
			filtro.setEmpresa(((FuncionarioEmpresa) usuario).getEmpresa());
		}
		return filtrar(filtro);
	}

}
