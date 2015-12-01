package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.cwi.crescer.dao.ItemDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.mapper.ItemMapper;

public class ItemServiceTest {
	
	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemDAO itemDAO;
	
	@Mock
	private PedidoDAO pedidoDAO;
	
	@Mock
	private ProdutoDAO produtoDAO;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void itemTemPrazo3() throws ParseException {
		Material material = new Material();
		material.setIdMaterial(1L);
		material.setDescricao("Pesado");
		
		Servico servico = new Servico();
		servico.setIdServico(1L);
		servico.setDescricao("Lavar");
		
		Produto produto = new Produto();
		produto.setIdProduto(1L);
		produto.setMaterial(material);
		produto.setServico(servico);
		produto.setPrazo(3);
		produto.setSituacao(SituacaoProduto.ATIVO);
		produto.setValor(new BigDecimal("5"));
		
		Pedido pedido = new Pedido();
		
		Item item = new Item();
		item.setIdItem(1L);
		item.setProduto(produto);
		item.setPeso(new BigDecimal("2"));
		item.setPedido(pedido);
		item.setValorUnitario(produto.getValor());
		item.setValorTotal(itemService.getValorTotalItem(item));
		
		Assert.assertEquals(new BigDecimal("10"), item.getValorTotal());
	}
	
	@Test
	public void valorTotalDoItemEh6() throws ParseException {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date date = fmt.parse("2013-05-06");
		
		Material material = new Material();
		material.setIdMaterial(1L);
		material.setDescricao("Pesado");
		
		Servico servico = new Servico();
		servico.setIdServico(1L);
		servico.setDescricao("Lavar");
		
		Produto produto = new Produto();
		produto.setIdProduto(1L);
		produto.setMaterial(material);
		produto.setServico(servico);
		produto.setPrazo(3);
		produto.setSituacao(SituacaoProduto.ATIVO);
		produto.setValor(new BigDecimal("5"));
		
		Pedido pedido = new Pedido();
		pedido.setDataInclusao(date);
		
		Item item = new Item();
		item.setIdItem(1L);
		item.setProduto(produto);
		item.setPedido(pedido);
		item.setValorUnitario(produto.getValor());
		
		
		
	}
	
}
