package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dao.SetorDAO;
import br.com.entity.Empresa;
import br.com.entity.SetorEmpresa;

@Stateless
public class SetorService {

	
	@PersistenceContext
	private EntityManager manager;
	
	
	@Inject
	private SetorDAO setorDAO;

	public void adiciona(SetorEmpresa setor) {
		this.manager.merge(setor);
	}

	public void remover(SetorEmpresa setor) {
		setor = this.manager.merge(setor);
		this.manager.remove(setor);
	}

	
/*	public List<SetorEmpresa> getSetorEmpresas() {
		List<SetorEmpresa> listasetors = new ArrayList<SetorEmpresa>();
		TypedQuery<SetorEmpresa> query = this.manager.createQuery("select x from SetorEmpresa x", SetorEmpresa.class);
		try {
			listasetors = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listasetors;
	}


	public SetorEmpresa pesquisaPorId(SetorEmpresa setor) {
		TypedQuery<SetorEmpresa> query = this.manager.createQuery("select x from SetorEmpresa x where idSetorEmpresa = :id", SetorEmpresa.class);
		query.setParameter("id", setor.getId());
		return query.getSingleResult();
	}*/

	public List<SetorEmpresa> listaSetorEmpresaPorEmpresa(Empresa empresa) {
		SetorEmpresa setor = new SetorEmpresa();
		setor.setEmpresa(empresa);
		return setorDAO.recuperarPorParametro(setor);
		
	}
}
