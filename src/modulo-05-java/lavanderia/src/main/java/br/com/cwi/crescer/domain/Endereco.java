package br.com.cwi.crescer.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable 
public class Endereco {

	@Column(name = "BAIRRO", length = 50)
	private String bairro;
	
	@Column(name = "CEP", length = 11)
	private Long cep;
	
	@Column(name = "ENDERECO", length = 50)
	private String endereco;

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}