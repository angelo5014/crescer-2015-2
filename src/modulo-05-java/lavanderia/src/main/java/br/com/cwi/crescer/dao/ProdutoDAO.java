package br.com.cwi.crescer.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Produto;

@Repository
public class ProdutoDAO extends AbstractDAO{

	public Produto findById(Long id){
		return em.find(Produto.class, id);
	}
	
	public List<Produto> findProduct(Long servico, Long material) {
		boolean servicoVazio = servico == 0;
		boolean materialVazio = material == 0;
		String sql = "FROM Produto p WHERE 1=1";
		if(!servicoVazio){
			sql += " AND p.servico.idServico = :idServico";
		}
		if (!materialVazio) {
			sql += " AND p.material.idMaterial = :idMaterial";
		}
		TypedQuery<Produto> query = em.createQuery(sql, Produto.class);
		
		if(!servicoVazio){
			query.setParameter("idServico", servico);
		}
		
		if(!materialVazio){
			query.setParameter("idMaterial", material);
		}
		return query.getResultList();
	}
	
	public List<Produto> listAll(){
		return em.createQuery("FROM Produto", Produto.class).getResultList();
	}
	
	@Transactional
	public Produto save(Produto produto) {
		if(produto.getIdProduto() == null){
			em.persist(produto);
			return produto;
		}
		em.merge(produto);
		return produto;
	}
	
}
