package br.com.cwi.crescer.domain;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
@SequenceGenerator(name = Cliente.SEQUENCE_NAME,sequenceName = Cliente.SEQUENCE_NAME, allocationSize = 1)
public class Cliente {
	
	public final static String SEQUENCE_NAME = "SEQ_Cliente";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name = "IDCliente")
	private Long idCliente;
	
	@Column(name = "Nome", length = 70)
	@Basic(optional=false)
	private String nome;
	
	@Column(name = "CPF", length = 11, unique = true)
	@Basic(optional = false)
	private String cpf;
	
	@Column(name = "Email", length = 100, unique = true)
	private String email;
	
	@Column(name = "BAIRRO", length = 50)
	private String bairro;
	
	@Column(name = "CEP", length = 11)
	private Long cep;
	
	@Column(name = "ENDERECO", length = 50)
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "IDCidade")
	private Cidade cidade;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "Situacao", length = 1)
	private SituacaoCliente situacao;
	
	@OneToMany(mappedBy = "cliente")
	private List<Pedido> pedidos;
	
	public static enum SituacaoCliente{
		ATIVO, INATIVO;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade Cidade) {
		this.cidade = Cidade;
	}

	public SituacaoCliente getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCliente situacao) {
		this.situacao = situacao;
	}
	
}
