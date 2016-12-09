package br.com.hotel.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_QUARTO")
public class Quarto implements Serializable {
	
	 
	/**
	 * 
	 */
	private static final long serialVersionUID = 6423558818751751465L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_QUARTO")
	private Integer codigo;
	
	@NotNull(message="É obrigatório informar o número de leitos.")
	@Column(name="NUM_LEITOS")
	private Integer numLeitos;
	
	
	@NotNull(message="É obrigatório informar o número do quarto.")
	@Column(name="NUM_QUARTO")
	private Integer numQuarto;
	
	@Column(name="TP_QUARTO")
	private TipoQuarto tipoQuarto;
	
	@Column(name="VR_DIARIA")
	private BigDecimal valorDiaria;
	
	public Quarto() {super();}
	
	public Quarto(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNumLeitos() {
		return numLeitos;
	}

	public void setNumLeitos(Integer numLeitos) {
		this.numLeitos = numLeitos;
	}

	public Integer getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}

	public TipoQuarto getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(TipoQuarto tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
}
