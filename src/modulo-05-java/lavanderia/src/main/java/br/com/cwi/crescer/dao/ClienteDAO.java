package br.com.cwi.crescer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;

@Repository
public class ClienteDAO extends AbstractDAO{

	public Cliente findById(Long id){
		return em.find(Cliente.class, id);
	}
	
	public List<Cliente> findByName(String name) {
		return em.createQuery("FROM Cliente c WHERE c.nome LIKE :name", Cliente.class)
				.setParameter("name", name + "%")
				.getResultList();
		
	}
	
	public Cliente findByCpf(String cpf) {
		return em.createQuery("FROM Cliente c WHERE c.cpf = :cpf", Cliente.class)
				.setParameter("cpf", cpf)
				.getResultList().get(0);
	}

	public List<Cliente> findBySituacao(SituacaoCliente situacao) {
        return em.createQuery("FROM Cliente c WHERE c.situacao = :situacao", Cliente.class)
                .setParameter("situacao", situacao)
                .getResultList();
    }
	
	public List<Cliente> listAll(){
		return em.createQuery("FROM Cliente", Cliente.class).getResultList();
	}
	
	@Transactional
	public Cliente save(Cliente cliente){
		if(cliente.getIdCliente() == null){
			em.persist(cliente);
			return cliente;
		}
		em.merge(cliente);
		return cliente;
	}
	
	@Transactional
	public void remove(Long id){
		em.remove(em.getReference(Cliente.class, id));
	}
}
