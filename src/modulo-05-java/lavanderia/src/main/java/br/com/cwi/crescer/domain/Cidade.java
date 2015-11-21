package br.com.cwi.crescer.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Cidade")
public class Cidade {
	
	@Id
	@Column(name = "idCidade")
	private Long idCidade;
	
	@Column(name = "nome", length = 50)
	@Basic(optional = false)
	private String nome;
	
	@Column(name = "UF", length = 2)
	@Basic(optional = false)
	private String uf;

}