package br.com.financeiro.controller;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.entity.Usuario;
import br.com.financeiro.service.UsuarioService;

@ManagedBean
@ViewScoped
public class UsuarioMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioService usuarioService;
	
	private Usuario usuarioLocal;
	private boolean logado;

	@PostConstruct
	private void init() {
		if (usuarioLocal == null)
			usuarioLocal = new Usuario();
	}

	public void alterarSenha() {
	System.out.println(usuarioService.obterUsuarioLogado().getEmail());
	}

	public Usuario getUsuarioLocal() {
		return usuarioLocal;
	}

	public void setUsuarioLocal(Usuario usuarioLocal) {
		this.usuarioLocal = usuarioLocal;
	}

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
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
