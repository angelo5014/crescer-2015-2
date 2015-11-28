package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO{

	public Produto findById(Long id){
		return em.find(Produto.class, id);
	}
	
	public List<Produto> listAll(){
		return em.createQuery("FROM Produto", Produto.class).getResultList();
	}
	
}
