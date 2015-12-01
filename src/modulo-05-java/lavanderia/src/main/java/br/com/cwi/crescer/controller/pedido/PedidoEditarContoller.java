package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoEditarContoller {

	private PedidoService pedidoService;
	
	@Autowired
	public PedidoEditarContoller(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@RequestMapping(path = "/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		pedidoService.atualizarInformacoes(id);
		return new ModelAndView("pedido/edita", "pedido", pedidoService.buscarPorId(id));
	}
	
	@RequestMapping(path = "/exibir/{id}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("id") Long id){
		return new ModelAndView("pedido/exibe", "pedido", pedidoService.buscarPorId(id));
	}
}
