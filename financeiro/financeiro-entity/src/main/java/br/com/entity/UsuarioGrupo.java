package br.com.entity;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import br.com.enums.GrupoPrivilegiosEnum;

@Entity
@Table(name="usuario_grupo")
public class UsuarioGrupo extends Entidade implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4756081134174062320L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToMany(mappedBy="grupos")
	private List<Usuario> usuarios;
	
	@Enumerated(EnumType.STRING)
	@Column(name="grupo")
	private GrupoPrivilegiosEnum grupo;
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public GrupoPrivilegiosEnum getGrupo() {
		return grupo;
	}
	
	public void setGrupo(GrupoPrivilegiosEnum grupo) {
		this.grupo = grupo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	
}
