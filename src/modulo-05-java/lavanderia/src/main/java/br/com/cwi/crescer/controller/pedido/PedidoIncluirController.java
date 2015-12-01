package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoIncluirController {
	
	private PedidoService pedidoService;


	@Autowired
	public PedidoIncluirController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping(path = "/incluir/{id}", method = RequestMethod.GET)
	public ModelAndView incluir(@PathVariable("id") Long id){
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setIdCliente(id);
		Long idPedido = pedidoService.incluir(pedidoDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + idPedido);
	}
	
}
