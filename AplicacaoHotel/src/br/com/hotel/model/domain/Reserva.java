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
import javax.validation.constraints.NotNull;
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
	
	@NotNull(message="Não foi informado o Cliente da Reserva!")
	@OneToOne
	@JoinColumn(name="CD_CLIENTE")
	private Cliente cliente;
	
	@Column(name="VR_TOTAL_RESERVA")
	private BigDecimal valorTotalReserva;
	
	@NotNull(message="Situação da reserva não foi informada!")
	@Enumerated(value=EnumType.STRING)
	@Column(name="CD_SITUACAO_RESERVA")
	private SituacaoReserva situacaoReserva;
	
	@NotNull(message="Data de Saída não foi informada!")
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DT_SAIDA")
	private Date dataSaida;
	
	@NotNull(message="Data de Entrada não foi informada!")
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="DT_ENTRADA")
	private Date dataEntrada;
	
	
	@Column(name="VR_DIARIA")
	private BigDecimal valorDiaria;
	
	@OneToOne
	@JoinColumn(name="CD_QUARTO")
	private Quarto quarto;
	
	@OneToOne
	@JoinColumn(name="CD_CONSUMO")
	private Consumo consumo;
	
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

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Consumo getConsumo() {
		return consumo;
	}

	public void setConsumo(Consumo consumo) {
		this.consumo = consumo;
	}
	
	
	
}
