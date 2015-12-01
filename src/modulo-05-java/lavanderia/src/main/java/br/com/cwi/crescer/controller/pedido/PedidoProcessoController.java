package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoProcessoController {
	
	private PedidoService pedidoService;


	@Autowired
	public PedidoProcessoController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping(path = "/processado", method = RequestMethod.POST)
	public ModelAndView processado(@ModelAttribute("pedido") PedidoDTO pedidoDTO){
		pedidoService.processarPedido(pedidoDTO.getId());
		return new ModelAndView("redirect:/pedidos/editar/" + pedidoDTO.getId());
	}
	
	
	@RequestMapping(path = "/processando", method = RequestMethod.POST)
	public ModelAndView processarItens(@ModelAttribute("pedido") PedidoDTO pedidoDTO){
		pedidoService.processandoPedido(pedidoDTO.getId());
		return new ModelAndView("redirect:/pedidos/editar/" + pedidoDTO.getId());
	}
	
}
