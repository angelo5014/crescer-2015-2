package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO extends AbstractDAO{

	public Cliente findById(Long id){
		return em.find(Cliente.class, id);
	}

	public List<Cliente> findBySituacao(SituacaoCliente situacao) {
        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
                .setParameter("situacao", situacao)
                .getResultList();
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
