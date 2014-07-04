package br.com.financeiro.service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.MenuDAO;
import br.com.entity.Menu;

@Stateless
@LocalBean
public class MenuService extends Service<Menu> {

	@Inject
	private MenuDAO dao;

	@Override
	public MenuDAO getDAO() {
		return dao;
	}

}
