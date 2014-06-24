package br.com.financeiro.service;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dao.LoginDAO;
import br.com.entity.PerfilUsuario;
import br.com.entity.Usuario;

@Stateless
public class UsuarioService {

	@PersistenceContext
	private EntityManager manager;
	@Resource 
	private SessionContext context;
	
	public Usuario alterarSenha(Usuario usuario) {
		return manager.merge(usuario);
	}
	
	@Inject
	private LoginDAO dao;
	
	
	public Usuario obterUsuarioLogado() {
		 Usuario usuario = dao.obterUsuarioPorLogin(context.getCallerPrincipal().getName());
		return usuario;
	}
	
	
	
	
}
