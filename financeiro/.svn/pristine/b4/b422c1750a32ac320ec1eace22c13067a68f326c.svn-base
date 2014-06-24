package br.com.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Usuario extends Entidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private Long id;

	@Column(name = "login", nullable = false)
	private String login;
	@Column(name = "senha", nullable = false)
	private String senha;

	@ManyToOne
	@JoinColumn(name = "idPerfilUsuario")
	private PerfilUsuario idPerfilUsuario;

	@ManyToMany
	@JoinTable(name = "usuario_has_grupo", joinColumns = { @JoinColumn(name = "usuario_id") }, inverseJoinColumns = { @JoinColumn(name = "usuariogrupo_id") })
	private List<UsuarioGrupo> grupos;

	@Column(name = "email")
	private String email;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "nome")
	private String nome;
	@Column(name = "telefone")
	private String telefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public PerfilUsuario getIdPerfilUsuario() {
		return idPerfilUsuario;
	}

	public void setIdPerfilUsuario(PerfilUsuario idPerfilUsuario) {
		this.idPerfilUsuario = idPerfilUsuario;
	}

	public List<UsuarioGrupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<UsuarioGrupo> grupos) {
		this.grupos = grupos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
