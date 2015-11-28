package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.dto.ServicoDTO;
import br.com.cwi.crescer.mapper.ServicoMapper;

@Service
public class ServicoService {
	private ServicoDAO servicoDAO;

	@Autowired
	public ServicoService(ServicoDAO servicoDAO) {
		this.servicoDAO = servicoDAO;
	}
	
	public List<ServicoDTO> listarMateriais() {
		List<Servico> servicos = servicoDAO.listAll();
		List<ServicoDTO> servicoDTO = new ArrayList<>();
		for (Servico servico : servicos) {
			servicoDTO.add(ServicoMapper.toDTO(servico));
		}
		return servicoDTO;
	}
}
