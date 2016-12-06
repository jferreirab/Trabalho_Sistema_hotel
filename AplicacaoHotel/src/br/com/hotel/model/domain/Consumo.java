package br.com.hotel.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement
@Entity
@Table(name="TB_CONSUMO")
public class Consumo implements Serializable{
	
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_CONSUMO")	
	private Integer codigo;

	@Column(name="DESCRICAO")
	private String descricao;	
	
	@Column(name="VR_TOTAL",precision=8,scale=2)
	private BigDecimal valorTotal;	
	
	/*@ManyToOne
	@JoinColumn(name="CD_RESERVA")
	private Reserva reserva;*/
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="CD_CONSUMO") 
	@JsonManagedReference
	private List<ItemConsumo> itemConsumo;

	public Consumo() {
		
	}
	
	public Consumo(Integer codigo) {
		this.codigo = codigo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	/*public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}*/

	public List<ItemConsumo> getItemConsumo() {
		return itemConsumo;
	}

	public void setItenConsumo(List<ItemConsumo> itemConsumo) {
		this.itemConsumo = itemConsumo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
}
