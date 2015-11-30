package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.dto.ItemDTO;

public class ItemMapper {

	public static Item getNewEntity(ItemDTO dto) {
		Item entity = new Item();
		entity.setPeso(dto.getPeso());
		return entity;
	}
	
	public static ItemDTO toDTO(Item entity){
		ItemDTO dto = new ItemDTO();
		dto.setId(entity.getIdItem());
		dto.setIdPedido(entity.getPedido().getIdPedido());
		dto.setIdProduto(entity.getProduto().getIdProduto());
		dto.setNomeServico(entity.getProduto().getServico().getDescricao());
		dto.setNomeMaterial(entity.getProduto().getMaterial().getDescricao());
		dto.setPeso(entity.getPeso());
		dto.setValorUnitario(entity.getValorUnitario());
		dto.setValorTotal(entity.getValorTotal());
		dto.setSituacao(entity.getSituacao().toString());
		return dto;
	}
	
}
