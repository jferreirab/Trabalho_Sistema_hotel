package br.com.hotel.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="TB_RESERVA")
public class Reserva implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CD_RESERVA")
	private Integer codigo;
	
	@OneToOne
	@JoinColumn(name="CD_CLIENTE")
	private Cliente cliente;
	
	@Column(name="VR_TOTAL_RESERVA")
	private BigDecimal valorTotalReserva;
	
	@Enumerated(value=EnumType.STRING)
	@Column(name="CD_SITUACAO_RESERVA")
	private SituacaoReserva situacaoReserva;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DT_SAIDA")
	private Date dataSaida;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DT_ENTRADA")
	private Date dataEntrada;
	
	public Reserva() {
		super();
	}
	
	public Reserva(Integer id) {
		this.codigo= id;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public BigDecimal getValorTotalReserva() {
		return valorTotalReserva;
	}
	
	public void setValorTotalReserva(BigDecimal valorTotalReserva) {
		this.valorTotalReserva = valorTotalReserva;
	}
	
	public SituacaoReserva getSituacaoReserva() {
		return situacaoReserva;
	}
	public void setSituacaoReserva(SituacaoReserva situacaoReserva) {
		this.situacaoReserva = situacaoReserva;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	
}
