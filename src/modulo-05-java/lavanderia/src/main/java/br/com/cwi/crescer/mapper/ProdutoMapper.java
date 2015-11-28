package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;

public class ProdutoMapper {
	
	public static Produto getNewEntity(ProdutoDTO dto){
		Produto entity = new Produto();
		entity.setIdProduto(dto.getId());
		entity.setValor(dto.getValor());
		entity.setPrazo(dto.getPrazo());
		entity.setSituacao(Enum.valueOf(SituacaoProduto.class, dto.getSituacao()));
		return entity;
	}
	
	public static ProdutoDTO toDTO(Produto entity) {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setId(entity.getIdProduto());
		dto.setIdMaterial(entity.getMaterial().getIdMaterial());
		dto.setNomeMaterial(entity.getMaterial().getDescricao());
		dto.setIdServico(entity.getServico().getIdServico());
		dto.setNomeServico(entity.getServico().getDescricao());
		dto.setValor(entity.getValor());
		dto.setSituacao(entity.getSituacao().toString());
		dto.setPrazo(entity.getPrazo());
		return dto;
	}
}
