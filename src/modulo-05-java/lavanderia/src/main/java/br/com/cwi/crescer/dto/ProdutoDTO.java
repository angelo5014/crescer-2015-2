package br.com.cwi.crescer.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class ProdutoDTO {
	
	private Long id;
	
	private Long idServico;
	
	private String nomeServico;
	
	private Long idMaterial;
	
	private String nomeMaterial;
	
	@NotNull
	private BigDecimal valor;
	
	@NotNull
	private int prazo;

	private String situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdServico() {
		return idServico;
	}

	public void setIdServico(Long idServico) {
		this.idServico = idServico;
	}
	
	public String getNomeServico() {
		return nomeServico;
	}
	
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Long getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Long idMaterial) {
		this.idMaterial = idMaterial;
	}
	
	public String getNomeMaterial() {
		return nomeMaterial;
	}
	
	public void setNomeMaterial(String nomeMaterial) {
		this.nomeMaterial = nomeMaterial;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public int getPrazo() {
		return prazo;
	}

	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
