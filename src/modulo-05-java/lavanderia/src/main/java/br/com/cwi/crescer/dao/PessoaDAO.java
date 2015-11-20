package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Pessoa;

@Repository
public class PessoaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Pessoa findById(Long id){
		return em.find(Pessoa.class, id);
	}
	
//	public Pessoa findById(Long id) {
//	
//		String queryStr = "SELECT p FROM Pessoa p WHERE p.idPessoa = :id";
//		 TypedQuery<Pessoa> query = em.createQuery(queryStr, Pessoa.class);
//		
//		query.setParameter("id", id);
//		
//		return query.getSingleResult();
//	}
	
}
