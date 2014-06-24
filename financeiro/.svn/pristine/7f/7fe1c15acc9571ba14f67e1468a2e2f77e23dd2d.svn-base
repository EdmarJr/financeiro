package br.com.financeiro.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.entity.Empresa;

@Stateless
public class EmpresaService {

	
	@PersistenceContext
	private EntityManager manager;

	public void adiciona(Empresa empresa) {
		this.manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = this.manager.merge(empresa);
		this.manager.remove(empresa);
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
}
