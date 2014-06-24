package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "funcionario_empresa")
@Entity
public class FuncionarioEmpresa extends Entidade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFuncionario_empresa")
	private Long id;

	@OneToOne
	@JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "idEmpresa", nullable = false, referencedColumnName = "idEmpresa")
	private Empresa empresa;

	@ManyToOne
	@JoinColumn(name = "idSetor_empresa", nullable = false, referencedColumnName = "idSetor_empresa")
	private SetorEmpresa setorEmpresa;

	@OneToOne
	@JoinColumn(name = "idFuncao", nullable = false, referencedColumnName = "idFuncao")
	private Funcao funcao;

	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(name = "telefone", nullable = false)
	private String telefone;
	@Column(name = "email", nullable = true)
	private String email;
	@Column(name = "endereco", nullable = false)
	private String endereco;
	@Column(name = "cep", nullable = true)
	private String cep;
	@ManyToOne
	@JoinColumn(name = "idCidade", referencedColumnName = "idCidade", nullable = false)
	private Cidade cidade;
	@ManyToOne
	@JoinColumn(name = "idEstado", referencedColumnName = "idEstado", nullable = false)
	private Estado estado;
	@Column(name = "rg", nullable = false)
	private String rg;
	@Column(name = "cpf", nullable = false)
	private String cpf;
	@Column(name = "salarioLiquido", nullable = false)
	private Double salarioLiquido;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}


	public SetorEmpresa getSetorEmpresa() {
		return setorEmpresa;
	}

	public void setSetorEmpresa(SetorEmpresa setorEmpresa) {
		this.setorEmpresa = setorEmpresa;
	}

	public Funcao getFuncao() {
		return funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

}
