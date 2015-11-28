package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.dto.MaterialDTO;

public class MaterialMapper {
	
	public static MaterialDTO toDTO(Material entity){
		MaterialDTO dto = new MaterialDTO();
		dto.setId(entity.getIdMaterial());
		dto.setDescricao(entity.getDescricao());
		return dto;
	}
	
}
