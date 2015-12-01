package br.com.cwi.crescer.service.pedido;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Pedido;

@Service
class PedidoItemService {
	
	public PedidoItemService() {
		// TODO Auto-generated constructor stub
	}
	
	public BigDecimal obterValorTotalDeItens(Pedido entity) {
		BigDecimal total = new BigDecimal(0);
		
		for (Item item : entity.getItens()) {
			total = total.add(item.getValorTotal());
		}
		
		return total;
	}
	
	public Date calcularDataEntrega(Pedido pedido) {
		int maiorPrazo = 0;
		for (Item item : pedido.getItens()) {
			int prazoItem = item.getProduto().getPrazo();
			maiorPrazo = prazoItem > maiorPrazo ? prazoItem : maiorPrazo;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(pedido.getDataInclusao());
		c.add(Calendar.DATE, maiorPrazo);
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" );
		return c.getTime();
	}
	
	public BigDecimal obterPesoDosItensDoPedido(Pedido entity){
		BigDecimal peso = new BigDecimal(0);
		
		List<Item> itens = entity.getItens();
		
		for (Item item : itens) {
			peso = peso.add(item.getPeso());
		}
		
		return peso;
	}
	
}