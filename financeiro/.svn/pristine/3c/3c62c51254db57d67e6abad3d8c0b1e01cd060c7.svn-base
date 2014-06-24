package br.com.financeiro.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.dao.LoginDAO;
import br.com.entity.LinkPerfil;
import br.com.entity.Menu;
import br.com.entity.PerfilUsuario;
import br.com.entity.Usuario;

@Stateless
public class LoginService {

	
	
	@Inject
	private LoginDAO loginDAO;
	
	public Usuario validaUsuario(Usuario usuario) {
		return loginDAO.validaUsuario(usuario);
	}

	public List<Menu> listaMenuPerfil(Usuario usuario) {

		return loginDAO.listaMenuPerfil(usuario);
	}

	public List<LinkPerfil> listaLinks(Usuario usuario) {
		return loginDAO.listaLinks(usuario);
	}

/*	public List<PerfilUsuario> listaPerfilPorLoja(Loja loja) {
		return loginDAO.listaPerfilPorLoja(loja);
	}*/

	
	
}
