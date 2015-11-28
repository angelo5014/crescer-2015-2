package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ItemService itemService;

	@Autowired
	public PedidoController(PedidoService pedidoService, ItemService itemService) {
		this.pedidoService = pedidoService;
		this.itemService = itemService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
	}
	
	@ModelAttribute("situacoes")
    public SituacaoPedido[] comboSituacoes() {
        return SituacaoPedido.values();
    }
	
}
