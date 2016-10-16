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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_CIDADE")
public class Cidade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CIDADE")
	private Integer codigo;
	
	@Column(name="DS_NOME_CIDADE",length=50)
	private String nomeCidade;
	
	// @ManyToOne
	//	@JoinColumn(name="CD_UF")
	@OneToOne
	@JoinColumn(name="CD_UF")
	private Estado estado;
	
	@Transient
	private String cidadeUF;

	 public Cidade() {
		super();
	}
	 
	public Cidade(Integer id) {
		this.codigo = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCidadeUF() {
		return this.getNomeCidade() ==null || this.getEstado().getUf() ==null ? "" : this.getNomeCidade() +" - "+this.getEstado().getUf();
	}
	
}
