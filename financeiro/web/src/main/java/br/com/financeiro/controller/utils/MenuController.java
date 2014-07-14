package br.com.financeiro.controller.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.entity.LinkPerfil;
import br.com.entity.Menu;
import br.com.entity.Usuario;
import br.com.financeiro.service.LoginService;
import br.com.financeiro.service.MenuService;
import br.com.financeiro.service.UsuarioService;

@Named
@SessionScoped
public class MenuController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private LoginService loginService;
	@EJB
	private MenuService menuService;
	@EJB
	private UsuarioService usuarioService;
	private List<LinkPerfil> listaLinks;
	private Usuario usuarioLogado;
	private Set<Menu> menus = new TreeSet<Menu>(new Comparator<Menu>() {

		@Override
		public int compare(Menu o1, Menu o2) {
			if (o1.getId().toString().equals(o2.getId().toString())) {
				return 0;
			}
			return 1;
		}
	});

	@PostConstruct
	private void inicializar() {
		listaLinks = new ArrayList<LinkPerfil>();
		usuarioLogado = usuarioService.obterUsuarioLogado();
		if (usuarioLogado != null) {
			if (listaLinks == null || listaLinks.isEmpty()) {
				listaLinks = loginService.listaLinks(usuarioLogado);
			}
			for (LinkPerfil links : listaLinks) {
				Menu menu = links.getIdLinksMenu().getIdMenu();
				menus.add(menu);
			}
		}
	}

	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	public List<LinkPerfil> getListaLinks() {
		return listaLinks;
	}

}
