package br.com.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idMenu")
	private Long id;
	
	private String descricao;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="idLinksMenu")
	private List<Link> linksMenu = new ArrayList<Link>();
	

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
	


	public List<Link> getLinksMenu() {
		if(linksMenu==null || linksMenu.isEmpty()){
			linksMenu = new ArrayList<Link>();
		}
		return linksMenu;
	}

	public void setLinksMenu(List<Link> linksMenu) {
		this.linksMenu = linksMenu;
	}
	
	
	
}
