package br.com.financeiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.dao.EmpresaDAO;
import br.com.entity.Empresa;
import br.com.entity.FuncionarioEmpresa;
import br.com.entity.Usuario;

@Stateless
public class EmpresaService extends Service<Empresa>{

	
	@PersistenceContext
	private EntityManager manager;
	@EJB
	private UsuarioService usuarioService;
	@Inject
	private EmpresaDAO empresaDAO;

	public void adiciona(Empresa empresa) {
		this.manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = this.manager.merge(empresa);
		this.manager.remove(empresa);
	}
	
	public List<Empresa> obterEmpresasDisponiveisInclusao() {
		Usuario usuario = usuarioService.obterUsuarioLogado();
		if (usuario instanceof FuncionarioEmpresa) {
			ArrayList<Empresa> empresas = new ArrayList<Empresa>();
			empresas.add(((FuncionarioEmpresa) usuario).getEmpresa());
			return empresas;
		} else {
			return obterTodos(Empresa.class);
		}
	}

	
	public List<Empresa> getEmpresas() {
		List<Empresa> listaempresas = new ArrayList<Empresa>();
		TypedQuery<Empresa> query = this.manager.createQuery("select x from Empresa x", Empresa.class);
		try {
			listaempresas = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaempresas;
	}


	public Empresa pesquisaPorId(Empresa empresa) {
		TypedQuery<Empresa> query = this.manager.createQuery("select x from Empresa x where idEmpresa = :id", Empresa.class);
		query.setParameter("id", empresa.getId());
		return query.getSingleResult();
	}

	public List<Empresa> pesquisaPorParametro(Empresa empresa) {
		return empresaDAO.recuperarPorParametro(empresa);
	}

	@Override
	public EmpresaDAO getDAO() {
		return empresaDAO;
	}
}
