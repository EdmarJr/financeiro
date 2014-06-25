package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.entity.Empresa;
import br.com.entity.FuncaoEmpresa;





public class FuncaoDAOImpl extends GenericDAOImpl<FuncaoEmpresa> implements FuncaoDAO {

	@Override
	public List<FuncaoEmpresa> getCargos() {
		Criteria criteria = obterCriteria(FuncaoEmpresa.class);
		return criteria.list();
		
	}

	@Override
	public FuncaoEmpresa pesquisaPorId(FuncaoEmpresa funcaoEmpresa) {
		Criteria criteria = obterCriteria(FuncaoEmpresa.class);
		criteria.add(Restrictions.eq("id",funcaoEmpresa));
		return (FuncaoEmpresa) criteria.uniqueResult();
	}

	@Override
	public List<FuncaoEmpresa> listaCargoPorLoja(Empresa empresa) {
		Criteria criteria = obterCriteria(FuncaoEmpresa.class);
		criteria.add(Restrictions.eq("empresa",empresa));
		return  criteria.list();
	}
	
	
	
	
	
}
