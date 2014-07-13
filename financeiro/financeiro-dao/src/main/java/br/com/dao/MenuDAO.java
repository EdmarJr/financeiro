package br.com.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.entity.Menu;

public class MenuDAO extends GenericDAOImpl<Menu> {
	public Menu obterPorId(Long id) {
		Criteria criteria = obterCriteria(Menu.class);
		criteria.add(Restrictions.eq("id", id));
		return (Menu) criteria.uniqueResult();

	}
}
