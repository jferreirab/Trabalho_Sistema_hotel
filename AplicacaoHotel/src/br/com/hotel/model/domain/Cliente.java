package br.com.hotel.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_CLIENTE")
public class Cliente implements Serializable{
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CLIENTE")
	private Integer codigo;
	
	@Column(name="DS_NOME",length=50)
	private String nome;
	
	@Column(name="DS_CPF" , length=15)
	private String cpf;
	
	@Column(name="DS_SEXO" )
	private Sexo sexo;
	
	@OneToOne
	@JoinColumn(name="CD_ENDERECO")
	private Logradouro endereco;
	
	@Column(name="Ds_numero")
	private String numero;
	
	@Column(name="DS_COMPLEMENTO")
	private String complemento;
	
	@Column(name="DS_EMAIL")
	private String email;
	
	@Column(name="DS_TELEFONE")
	private String telefone;
	
	@Column(name="DS_CELULAR")
	private String celular;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Cliente() {
		super();
	}
	
	public Cliente(Integer id) {
		this.codigo = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Logradouro getEndereco() {
		return endereco;
	}

	public void setEndereco(Logradouro endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
