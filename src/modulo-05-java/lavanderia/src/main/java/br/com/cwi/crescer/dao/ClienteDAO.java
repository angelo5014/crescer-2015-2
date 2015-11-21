package br.com.cwi.crescer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;

@Repository
public class ClienteDAO {

	@PersistenceContext
	private EntityManager em;
	
	public Cliente findById(Long id){
		return em.find(Cliente.class, id);
	}

//	public Cliente findById(Long id) {
//	
//		String queryStr = "SELECT c FROM Cliente c WHERE c.idCliente = :id";
//		 TypedQuery<Cliente> query = em.createQuery(queryStr, Cliente.class);
//		
//		query.setParameter("id", id);
//		
//		return query.getSingleResult();
//	}
	
}
