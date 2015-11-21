package br.com.cwi.crescer.domain;

import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Item")
@SequenceGenerator(name = Item.SEQUENCE_NAME,sequenceName = Item.SEQUENCE_NAME)
public class Item {
	
	public final static String SEQUENCE_NAME = "SEQ_item";
	
	@Id
	@Column(name = "IdItem")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	private Long idItem;
	
	@Column(name = "IdPedido")
	@Basic(optional = false)
	private Long idPedido;
	
	@Column(name = "IdProduto")
	@Basic(optional = false)
	private Long idProduto;
	
	@Column(name = "peso")
	@ Basic(optional = false)
	private double peso;
	
	@Column(name = "ValorUnitario")
	@Basic(optional = false)
	private BigDecimal valorUnitario;
	
	@Column(name = "ValorDesconto")
	@Basic(optional = false)
	private BigDecimal valorDesconto;
	
	@Column(name = "ValorTotal")
	@Basic(optional = false)
	private BigDecimal valorTotal;

	@Column(name = "Situacao", length = 1)
	private char situacao;

	public Long getIdItem() {
		return idItem;
	}

	public void setIdItem(Long idItem) {
		this.idItem = idItem;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	
}
