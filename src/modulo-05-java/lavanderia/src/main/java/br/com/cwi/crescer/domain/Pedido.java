package br.com.cwi.crescer.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pedido")
@SequenceGenerator(name = Pedido.SEQUENCE_NAME,sequenceName = Pedido.SEQUENCE_NAME)
public class Pedido {
	
	public final static String SEQUENCE_NAME = "SEQ_pedido";
	
	@Id
	@Column(name = "IDPedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idPedido;
	
	@ManyToOne
	@JoinColumn(name = "IDCliente")
	@Basic(optional = false)
	private Cliente cliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATAInclusao")
	@Basic(optional = false)
	private Date dataInclusao;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATAEntrega")
	private Date dataEntrega;
	
	@Column(name = "Valor")
	@Basic(optional = false)
	private BigDecimal valor;
	
	@Column(name = "Situacao", length = 1)
	private SituacaoPedido situacao;
	
	public static enum SituacaoPedido{
		PENDENTE, PROCESSANDO, PROCESSADO, ENCERRADO, CANCELADO;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setIdCliente(Cliente Cliente) {
		this.cliente = Cliente;
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

	public SituacaoPedido getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoPedido situacao) {
		this.situacao = situacao;
	}
	
	
}
