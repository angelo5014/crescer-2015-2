package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ServicoDTO;

public class ServicoMapper {
	
	public static ServicoDTO toDTO(Servico entity){
		ServicoDTO dto = new ServicoDTO();
		dto.setId(entity.getIdServico());
		dto.setDescricao(entity.getDescricao());
		return dto;
	}
	
}
