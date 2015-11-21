package br.com.cwi.crescer.domain;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME,sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {
	
	public final static String SEQUENCE_NAME = "SEQ_pedido";
	
	@Id
	@Column(name = "IdPedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idPedido;
	
	@Column(name = "IdCliente")
	@Basic(optional = false)
	private Long idCliente;
	
	@Column(name = "DataInclusao")
	@Basic(optional = false)
	private Date dataInclusao;
	
	@Column(name = "DataEntrega")
	private Date dataEntrega;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;
	
	@Column(name = "Situacao", length = 1)
	private char situacao;

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	
	
}
