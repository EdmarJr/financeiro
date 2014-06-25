package br.com.financeiro.controller;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.entity.Usuario;


public abstract class BasicoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	public abstract void adiciona ();
	public abstract void listar() ;
	public abstract void remover();
	public abstract void limpar();
	public abstract void editar();
	
	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
	DecimalFormat qtdeParser = new DecimalFormat( "0.00");
	
	HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
	
	public void retornaMensagemWARN(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,mensagem,mensagem));
	}
	
	public void retornaMensagemSucesso(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,mensagem,mensagem));
	}
	
	public void retornaMensagemSucessoOperacao(){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Opera��o realizada com sucesso","Opera��o realizada com sucesso"));
	}
	
	public void retornaMensagemErro(String mensagem){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,mensagem,mensagem));
	}
	
	
	public Usuario getUsuario() {
		if(usuario==null || usuario.getId()==null){
			usuario = (Usuario) session.getAttribute("userManager");  
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		session.setAttribute("userManager", usuario);
		this.usuario = usuario;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
	
}
