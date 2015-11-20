package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoa")
public class Pessoa {
	
	@Id
	@Column(name = "idPessoa")
	private Long idPessoa;
	
	
	@Column(name = "Nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "idEndereco", length = 10)
	private Long idEndereco;
	
}
