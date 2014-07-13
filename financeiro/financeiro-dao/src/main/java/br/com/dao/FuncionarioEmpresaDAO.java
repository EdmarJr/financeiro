package br.com.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.entity.Empresa;
import br.com.entity.FuncionarioEmpresa;

public class FuncionarioEmpresaDAO extends GenericDAOImpl<FuncionarioEmpresa> {
	public FuncionarioEmpresa obterFuncionarioPorEmailEmpresa(Empresa empresa, String email) {
		Criteria criteria = obterCriteria(FuncionarioEmpresa.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("empresa", empresa));
		return (FuncionarioEmpresa) criteria.uniqueResult();
	}
}
