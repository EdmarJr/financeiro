package br.com.financeiro.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Link;
import br.com.entity.Menu;
import br.com.entity.PerfilUsuario;
import br.com.financeiro.service.MenuService;

@ManagedBean
@ViewScoped
public class ManterPerfilMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7869679819609073557L;

	private Menu perfilUsuario;
	private List<Menu> listaPerfilUsuario;
	private List<Link>  listaMenu;
	
	@EJB
	private MenuService menuService;
	
	@PostConstruct
	private void init() {
		listaPerfilUsuario = menuService.listaTodos();
		for(Menu m : listaPerfilUsuario){
			System.out.println(m.getDescricao());
		}
	}
	
	
	public void listaLinksPerfis() {
		listaMenu = perfilUsuario.getLinksMenu();
	}
	

	@Override
	public void listar() {
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


	@Override
	public void adiciona() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void remover() {
		// TODO Auto-generated method stub
		
	}


	public Menu getPerfilUsuario() {
		return perfilUsuario;
	}


	public void setPerfilUsuario(Menu perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}


	public List<Menu> getListaPerfilUsuario() {
		return listaPerfilUsuario;
	}


	public void setListaPerfilUsuario(List<Menu> listaPerfilUsuario) {
		this.listaPerfilUsuario = listaPerfilUsuario;
	}


	public List<Link> getListaMenu() {
		return listaMenu;
	}


	public void setListaMenu(List<Link> listaMenu) {
		this.listaMenu = listaMenu;
	}



	 
	

	 
	
	
}
