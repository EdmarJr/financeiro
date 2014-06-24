package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "empresa")
@Entity
public class Empresa extends Entidade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEmpresa")
	private Long id;

	@Column(name = "nomeFantasia", nullable = false)
	private String nomeFantasia;

	@Column(name = "razaoSocial", nullable = false)
	private String razaoSocial;

	@Column(name = "cnpj", nullable = false)
	private String cnpj;

	@Column(name = "endereco", nullable = false)
	private String endereco;

	@Column(name = "cep", nullable = false)
	private String cep;

	@ManyToOne
	@JoinColumn(name = "idCidade", referencedColumnName = "idCidade", nullable = false)
	private Cidade cidade;

	@ManyToOne
	@JoinColumn(name = "idEstado", nullable = false, referencedColumnName = "idEstado")
	private Estado estado;

	@Column(name = "atividadeEconomica", nullable = false)
	private String atividadeEconomica;

	@Column(name = "telefone1", nullable = false)
	private String telefone1;

	@Column(name = "telefone2", nullable = true)
	private String telefone2;

	@Column(name = "email", nullable = false)
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getAtividadeEconomica() {
		return atividadeEconomica;
	}

	public void setAtividadeEconomica(String atividadeEconomica) {
		this.atividadeEconomica = atividadeEconomica;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
