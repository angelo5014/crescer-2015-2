package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.mapper.ItemMapper;

@Service
public class ItemService {

	private ItemDAO itemDAO;
	private PedidoDAO pedidoDAO;
	private ProdutoDAO produtoDAO;

	@Autowired
	public ItemService(ItemDAO itemDAO, PedidoDAO pedidoDAO, ProdutoDAO produtoDAO) {
		this.itemDAO = itemDAO;
		this.pedidoDAO = pedidoDAO;
		this.produtoDAO = produtoDAO;
	}
	
	public ItemDTO buscarItemPorId(Long id) {
		return ItemMapper.toDTO(itemDAO.findById(id));
	}
	
	public void inserirItem(ItemDTO itemDTO) {
		Item item = ItemMapper.getNewEntity(itemDTO);
		item.setPedido(pedidoDAO.findById(itemDTO.getIdPedido()));
		item.setProduto(produtoDAO.findProduct(itemDTO.getIdServico(), itemDTO.getIdMaterial()).get(0));
		item.setValorUnitario(produtoDAO.findById(item.getProduto().getIdProduto()).getValor());
		item.setValorTotal(getValorTotalItem(item));
		item.setSituacao(SituacaoItem.PENDENTE);
		itemDAO.save(item);
	}
	
	public void processarItem(Long id){
		setSituacaoItem(id, SituacaoItem.PROCESSADO);
	}
	
	private void setSituacaoItem(Long id, SituacaoItem situacao){
		Item entity = itemDAO.findById(id);
		entity.setSituacao(situacao);
		
		itemDAO.save(entity);
	}
	
	private BigDecimal getValorTotalItem(Item item){
		return item.getValorUnitario().multiply(item.getPeso(), MathContext.DECIMAL128);
	}
	
}
