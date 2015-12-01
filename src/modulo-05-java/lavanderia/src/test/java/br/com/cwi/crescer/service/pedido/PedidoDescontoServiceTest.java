package br.com.cwi.crescer.service.pedido;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Material;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.domain.Servico;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;

public class PedidoDescontoServiceTest {

	private PedidoDescontoService descontoService = new PedidoDescontoService(new PedidoItemService());
	
	private void enviaPedidoCom30RecebeDesconto2e4() throws ParseException {
		
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
		pedido.setIdPedido(1L);
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		
		Item item = new Item();
		item.setIdItem(1L);
		item.setProduto(produto);
		item.setPedido(pedido);
		item.setSituacao(SituacaoItem.PENDENTE);
		
		pedido.setDataInclusao(date);
		
		
	}
	
}
