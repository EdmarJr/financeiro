package br.com.dao;


import java.util.Date;
import java.util.List;

import br.com.entity.LinkPerfil;
import br.com.entity.Menu;
import br.com.entity.Usuario;

public interface LoginDAO extends GenericDAO<Usuario> {
	
	Usuario recuperarPorId(Long id);
	
	List<Usuario> pesquisar(Usuario tipoPagamento);
	
	Usuario recuperarPorNome(String nome);

	List<Usuario> consultaPagamento(Usuario usuario);
	
	
	List<Usuario> listar(Date dataInicio, Date dataFim);
	
	public Usuario validaUsuario(Usuario usuario);
	public List<Menu> listaMenuPerfil(Usuario usuario);
	public List<LinkPerfil> listaLinks(Usuario usuario);

	Usuario obterUsuarioPorLogin(String login);

}
