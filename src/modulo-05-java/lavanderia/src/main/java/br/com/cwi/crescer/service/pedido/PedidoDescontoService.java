package br.com.cwi.crescer.service.pedido;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.service.CalendarioService;

@Service
public class PedidoDescontoService {
	
	private PedidoItemService pedidoItemService;
	
	@Autowired
	public PedidoDescontoService(PedidoItemService pedidoItemService) {
		this.pedidoItemService = pedidoItemService;
	}

	private CalendarioService calendarioService = new CalendarioService();
	
	private final BigDecimal descontoPorPesoValor = new BigDecimal(0.0487).setScale(2, BigDecimal.ROUND_DOWN);//4.87%
	private final BigDecimal descontoSegundaAQuarta = new BigDecimal(0.08).setScale(2, BigDecimal.ROUND_DOWN);//8%
	private final BigDecimal descontoQuintaOuSexta = new BigDecimal(0.04).setScale(2, BigDecimal.ROUND_DOWN);//4%
	
	public BigDecimal calcularDesconto(Pedido entity){
		return entity.getValorBruto().multiply(obterPercentualDeDesconto(entity), MathContext.DECIMAL128);
	}
	
	public BigDecimal obterPercentualDeDesconto(Pedido entity){
		BigDecimal desconto = new BigDecimal(0);
		
		Date dataInclusao = entity.getDataInclusao();
		
		BigDecimal pesoTotalDosItens = pedidoItemService.obterPesoDosItensDoPedido(entity);
		BigDecimal valorTotalDosItens = pedidoItemService.obterValorTotalDeItens(entity);
		
		if(descontoPorPesoOuValor(pesoTotalDosItens, valorTotalDosItens)){
			desconto = desconto.compareTo(descontoPorPesoValor) < 0 ? descontoPorPesoValor : desconto;
		}

		if(calendarioService.diaEhSegundaAQuarta(dataInclusao)){
			desconto = desconto.compareTo(descontoSegundaAQuarta) < 0 ? descontoSegundaAQuarta : desconto;
		}
		
		if (calendarioService.diaEhQuintaOuSexta(dataInclusao)){
			desconto = desconto.compareTo(descontoQuintaOuSexta) < 0 ? descontoQuintaOuSexta : desconto;
		}
		
		return desconto;
	}
	
	private boolean descontoPorPesoOuValor(BigDecimal peso, BigDecimal valor){
		BigDecimal pesoAceito = new BigDecimal(15);
		BigDecimal valorAceito = new BigDecimal(90);
		
		return peso.compareTo(pesoAceito) > 0 || valor.compareTo(valorAceito) > 0;
	}
}