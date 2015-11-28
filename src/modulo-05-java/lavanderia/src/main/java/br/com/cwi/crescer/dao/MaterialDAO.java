package br.com.cwi.crescer.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.cwi.crescer.domain.Material;

@Repository
public class MaterialDAO extends AbstractDAO{
	
	public Material findById(Long id){
		return em.find(Material.class, id);
	}
	
	public List<Material> listAll(){
		return em.createQuery("FROM Material", Material.class).getResultList();
	}
	
}
