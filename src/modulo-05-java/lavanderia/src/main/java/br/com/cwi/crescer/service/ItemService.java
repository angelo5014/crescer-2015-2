package br.com.cwi.crescer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {

	private ItemDAO itemDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	public ItemDTO buscarItemPorId(Long id) {
		return ItemMapper.toDTO(itemDAO.findById(id));
	}
	
}
