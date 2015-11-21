package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE_NAME,sequenceName = Cliente.SEQUENCE_NAME)
public class Cliente {
	
	public final static String SEQUENCE_NAME = "SEQ_servico";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "idCliente")
	private Long idCliente;
	
	@Column(name = "Nome", length = 70)
	@Basic(optional=false)
	private String nome;
	
	@Column(name = "CPF", length = 11, unique = true)
	@Basic(optional = false)
	private String cpf;
	
	@Column(name = "Email", length = 100, unique = true)
	private String email;
	
	@Column(name = "Endereco", length = 50)
	private String endereco;
	
	@Column(name = "Bairro", length = 50)
	private String bairro;
	
	@Column(name = "IdCidade")
	private Long idCidade;
	
	@Column(name = "CEP", length = 8)
	private Long cep;
	
	@Column(name = "Situacao", length = 1)
	private char situacao;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}

	public char getSituacao() {
		return situacao;
	}

	public void setSituacao(char situacao) {
		this.situacao = situacao;
	}
	
}
