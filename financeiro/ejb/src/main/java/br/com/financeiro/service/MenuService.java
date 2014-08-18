package br.com.financeiro.service;

import java.util.List;

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

	public Menu obterPorId(Long id) {
		return getDAO().obterPorId(id);
	}
	
	@Override
	public MenuDAO getDAO() {
		return dao;
	}

	public List<Menu> listaTodos() {
		return dao.recuperarTodos(Menu.class);
	}

}
