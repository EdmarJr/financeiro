package br.com.financeiro.login;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import br.com.entity.LinkPerfil;
import br.com.entity.Link;
import br.com.entity.Menu;
import br.com.entity.Usuario;
import br.com.financeiro.controller.BasicoMB;
import br.com.financeiro.service.LoginService;
import br.com.financeiro.service.UsuarioService;

@ManagedBean
@ViewScoped
public class MenuMB extends BasicoMB {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private LoginService loginService;

	private List<Menu> listaMenu = new ArrayList<Menu>();

	private Usuario usuario = new Usuario();

	private MenuModel model;

	@EJB
	private UsuarioService usuarioServices;
	private List<LinkPerfil> listaLinks = new ArrayList<LinkPerfil>();

	@PostConstruct
	private void init() {

		if (listaLinks == null || listaLinks.isEmpty()) {
			if(getUsuario()==null || getUsuario().getId()==null)
				setUsuario(usuarioServices.obterUsuarioLogado());
			
			listaLinks = loginService.listaLinks(getUsuario());
		}

		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		if (session.getAttribute("menus") != null) {
			model = new DefaultMenuModel();
			model = (MenuModel) session.getAttribute("menus");
			if (model.getElements().isEmpty())
				criarMenu();
		} else {
			criarMenu();
		}
	}


	public void criarMenu() {
		if (model == null || model.getElements().isEmpty()) {
			model = new DefaultMenuModel();

			for (LinkPerfil lista : getListaLinks()) {
				Menu menu = new Menu();
				if (!listaMenu.contains(lista.getIdLinksMenu().getIdMenu())) {
					menu = lista.getIdLinksMenu().getIdMenu();
					Link link = new Link();
					link = lista.getIdLinksMenu();
					menu.setLinksMenu(null);
					menu.getLinksMenu().add(link);
					listaMenu.add(menu);
				} else {
					Link link = new Link();
					link = lista.getIdLinksMenu();
					listaMenu.get(listaMenu.size() - 1).getLinksMenu()
							.add(link);
				}
			}

			MenuModel model = new DefaultMenuModel();

			/*
			 * DefaultSubMenu subMenu = new DefaultSubMenu("some submenu");
			 * DefaultMenuItem menuItem = new DefaultMenuItem("some item");
			 * subMenu.addElement(menuItem);
			 * 
			 * model.addElement(subMenu);
			 * 
			 * model.generateUniqueIds();
			 */

			for (Menu menu : getListaMenu()) {
				DefaultSubMenu submenu = new DefaultSubMenu();
				submenu.setLabel(menu.getDescricao());
				submenu.setId("menu_" + menu.getId().toString());

				for (Link subMenu : menu.getLinksMenu()) {
					DefaultMenuItem item = new DefaultMenuItem();
					item.setValue(subMenu.getDescricao());
					item.setUrl(subMenu.getPagina());
					item.setId("sid_" + subMenu.getId().toString());
					submenu.addElement(item);
				}

				model.addElement(submenu);
			}
			DefaultMenuItem item = new DefaultMenuItem();
			item.setValue("Sair");
			item.setId("menu_Sair");
			item.setUrl("/index.xhtml");

			model.addElement(item);

			HttpSession session = (HttpSession) FacesContext
					.getCurrentInstance().getExternalContext().getSession(true);
			session.setAttribute("menus", model);
		}
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

	public List<Menu> getListaMenu() {
		return listaMenu;
	}

	public void setListaMenu(List<Menu> listaMenu) {
		this.listaMenu = listaMenu;
	}

	public List<LinkPerfil> getListaLinks() {
		return listaLinks;
	}

	public void setListaLinks(List<LinkPerfil> listaLinks) {
		this.listaLinks = listaLinks;
	}

	@Override
	public void adiciona() {
		// TODO Auto-generated method stub

	}

	@Override
	public void listar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover() {
		// TODO Auto-generated method stub

	}

	@Override
	public void limpar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub

	}

}
