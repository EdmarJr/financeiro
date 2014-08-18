package br.com.financeiro.controller;


import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.entity.Usuario;
import br.com.financeiro.service.LoginService;

@ManagedBean
public class LoginMB extends BasicoMB{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7839716487957894350L;

	@EJB
	private LoginService loginService;
	
	private Usuario usuario = new Usuario();
	private boolean logado;
	
	
	public void login(){
		if(usuario!=null && usuario.getSenha()!=null)
			usuario = loginService.validaUsuario(usuario);
		if(usuario!=null && usuario.getId()!=null){
			try {
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.setAttribute("userManager",usuario);  
				setLogado(true);
				FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(usuario==null || usuario.getId()==null){
			try {
				usuario = new Usuario();
				FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
				session.setAttribute("userManager",usuario);  
				setLogado(true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Login ou senha inv�lida","Login ou senha inv�lida"));
		}
	}
	
	

	public void logout() {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			session.invalidate();
			usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
