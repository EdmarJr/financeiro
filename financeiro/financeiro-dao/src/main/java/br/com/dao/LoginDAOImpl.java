package br.com.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.entity.LinkPerfil;
import br.com.entity.Menu;
import br.com.entity.PerfilUsuario;
import br.com.entity.Usuario;





public class LoginDAOImpl extends GenericDAOImpl<Usuario> implements LoginDAO {
	
	@Override
	public Usuario recuperarPorId(Long id) {
		return manager.getReference(Usuario.class, id);
	}

	
	public Usuario validaUsuario(Usuario usuario) {
		try {
			Query query = manager.createNativeQuery("select x from Usuario x where x.login = :login and x.senha = :senha", Usuario.class);
			query.setParameter("login", usuario.getEmail());
			query.setParameter("senha", usuario.getSenha());
			return (Usuario)query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> pesquisar(Usuario usuario) {
		StringBuilder jpql = new StringBuilder();
		jpql.append("select e from Usuario e ");
		jpql.append("where e.nome like :nome ");
		Query query = manager.createQuery(jpql.toString());
		//query.setParameter("nome", '%' + usuario.getNome() + '%');
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Usuario recuperarPorNome(String nome) {
		String jpql = "select te from Usuario te "
					+ "where te.nome = :nome ";
		
		Query query = manager.createQuery(jpql);
		query.setParameter("nome", nome);
		List<Usuario> lista = query.getResultList();
		if (lista == null || lista.isEmpty())
			return null;
		return lista.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> consultaPagamento(Usuario usuario) {
		StringBuilder sql = new StringBuilder();
		sql.append("select e from Usuario e where 1 = 1");
		
		HashMap<String, Object> parametros = new HashMap<String, Object>();
		/*if(usuario.getNome()!=null && !usuario.getNome().equals("")){
			sql.append(" and e.nome like :nome");
			parametros.put("nome", "%"+usuario.getNome()+"%");
		}if(usuario.getTipoPagamento()!=null && usuario.getTipoPagamento().getId()>0){
			sql.append(" and e.tipoPagamento=:tipoPagamento");
			parametros.put("tipoPagamento", usuario.getTipoPagamento());
		}if(usuario.getDataInicio()!=null){
			sql.append(" and e.dataInicio>=:dataInicio");
			parametros.put("dataInicio", usuario.getDataInicio());
		}if(usuario.getDataFim()!=null){
			sql.append(" and e.dataFim<=:dataFim");
			parametros.put("dataFim", usuario.getDataFim());
		}if(usuario.getStatus()!='\0'){
			sql.append(" and e.status=:status");
			parametros.put("status", usuario.getStatus());
		}if(usuario.getLocal()!=null && usuario.getLocal().getId()>0){
			sql.append(" and e.local=:local");
			parametros.put("local", usuario.getStatus());
		}*/

		List<? extends Object> listaPagamento = executarQueryJPQL(sql.toString(), parametros);
		return (List<Usuario>)listaPagamento;
		
	}


	@Override
	public List<Usuario> listar(Date dataInicio, Date dataFim) {
		List<Usuario> lista = new ArrayList<Usuario>();
		String lcQuery = "select x from Usuario x where 1=1";
		if (dataInicio != null ) {
			lcQuery += " where date(x.dataCompra)>=date(:dataInicio)";
		}
		if (dataFim != null) {
			lcQuery += " and date(x.dataCompra)<=date(:dataFim)";
		}
		lcQuery += " order by x.dataCompra desc";
		Query query = this.manager.createNativeQuery(lcQuery, Usuario.class);
		
		if (dataInicio != null ) {
			query.setParameter("dataInicio", dataInicio);
		}
		if (dataFim != null) {
			query.setParameter("dataFim", dataFim);
		}

		lista = query.getResultList();
		return lista;
	}

	public List<Menu> listaMenuPerfil(Usuario usuario) {
		Query query = manager.createNativeQuery("select x from Menu x where x.idPerfilusuario = :perfil", Menu.class);
//		query.setParameter("perfil", usuario.getIdPerfilUsuario());
		return (List<Menu>)query.getResultList();
	}
	
	public List<LinkPerfil> listaLinks(Usuario usuario) {
		
		Criteria criteria = obterCriteria(LinkPerfil.class);
		criteria.add(Restrictions.eq("idPerfilusuario",usuario.getIdPerfilUsuario()));
//		criteria.addOrder(Order.asc("linkMenu.menu"));
		return criteria.list();
	}
	
/*	public List<PerfilUsuario> listaPerfilPorLoja(Loja loja) {
		Query query = manager.createNativeQuery("select x from PerfilUsuario x "
				+ " order by x.descricao", PerfilUsuario.class);
		List<PerfilUsuario> lista = (List<PerfilUsuario>)query.getResultList();
		return lista;
	}*/

	@Override
	public Usuario obterUsuarioPorLogin(String login) {
		Criteria criteria = obterCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", login));
		return (Usuario) criteria.uniqueResult();
	}



	
	
	
}
