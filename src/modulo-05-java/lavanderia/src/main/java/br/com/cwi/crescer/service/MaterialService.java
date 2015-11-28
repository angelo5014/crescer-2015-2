package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.dto.MaterialDTO;
import br.com.cwi.crescer.mapper.MaterialMapper;

@Service
public class MaterialService {

	private MaterialDAO materialDAO;

	@Autowired
	public MaterialService(MaterialDAO materialDAO) {
		this.materialDAO = materialDAO;
	}
	
	public List<MaterialDTO> listarMateriais() {
		List<Material> materiais = materialDAO.listAll();
		List<MaterialDTO> materialDTO = new ArrayList<>();
		for (Material material : materiais) {
			materialDTO.add(MaterialMapper.toDTO(material));
		}
		return materialDTO;
	}
	
}
