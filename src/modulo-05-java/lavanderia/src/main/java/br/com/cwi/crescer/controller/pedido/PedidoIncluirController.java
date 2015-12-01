package br.com.cwi.crescer.controller.pedido;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoIncluirController {
	
	private PedidoService pedidoService;
	private ClienteService clienteService;

	@Autowired
	public PedidoIncluirController(PedidoService pedidoService, ClienteService clienteService) {
		this.pedidoService = pedidoService;
		this.clienteService= clienteService;
	}
	
	@RequestMapping(path = "/incluir/{id}", method = RequestMethod.GET)
	public ModelAndView incluir(@PathVariable("id") Long id){
		PedidoDTO pedidoDTO = new PedidoDTO();
		pedidoDTO.setIdCliente(id);
		Long idPedido = pedidoService.incluir(pedidoDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + idPedido);
	}
	
	/*@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("pedido") PedidoDTO pedidoDTO,
											BindingResult result,
											final RedirectAttributes redirectAttributes){
		Long id = pedidoService.incluir(pedidoDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + id);
	}*/
	
	@ModelAttribute("clientes")
    public List<ClienteDTO> comboClientes() {
        return clienteService.listarClientes();
    }
	
}
