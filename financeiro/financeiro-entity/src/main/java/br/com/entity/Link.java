package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="linksmenu")
public class Link {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLinksMenu")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="idMenu", referencedColumnName="idMenu")
	private Menu idMenu = new Menu();
	
	
	
	private String descricao;
	
	private String pagina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPagina() {
		return pagina;
	}

	public void setPagina(String pagina) {
		this.pagina = pagina;
	}

	public Menu getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Menu idMenu) {
		this.idMenu = idMenu;
	}
	
	
	
	
	
}
