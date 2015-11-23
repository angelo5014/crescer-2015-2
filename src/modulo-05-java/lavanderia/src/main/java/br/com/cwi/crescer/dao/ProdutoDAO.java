package br.com.cwi.crescer.dao;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO{

	public Produto findById(Long id){
		return em.find(Produto.class, id);
	}
	
}
