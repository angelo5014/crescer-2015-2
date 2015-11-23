package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Servico;

@Repository
public class ServicoDAO extends AbstractDAO{
	
	public Servico findById(Long id){
		return em.find(Servico.class, id);
	}
	
}
