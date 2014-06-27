package br.com.financeiro.controller.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.entity.LinkPerfil;
import br.com.entity.Usuario;
import br.com.financeiro.service.LoginService;
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
	private UsuarioService usuarioService;
	private List<LinkPerfil> listaLinks;
	private Usuario usuarioLogado;

	@PostConstruct
	private void inicializar() {
		listaLinks = new ArrayList<LinkPerfil>();
		usuarioLogado = usuarioService.obterUsuarioLogado();
		if (listaLinks == null || listaLinks.isEmpty()) {
			listaLinks = loginService.listaLinks(usuarioLogado);
		}
	}
	
	public List<LinkPerfil> getListaLinks() {
		return listaLinks;
	}

}
