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
@Table(name="Servico")
@SequenceGenerator(name = Servico.SEQUENCE_NAME,sequenceName = Servico.SEQUENCE_NAME)
public class Servico {

	public final static String SEQUENCE_NAME = "SEQ_servico";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	@Column(name="idServico")
	private String idServico;
	
	@Column(name="Descricao", length = 30)
	@Basic(optional = false)
	private String descricao;

	public String getIdServico() {
		return idServico;
	}

	public void setIdServico(String idServico) {
		this.idServico = idServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}