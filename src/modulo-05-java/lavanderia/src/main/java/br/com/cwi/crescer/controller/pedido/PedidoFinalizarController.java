package br.com.cwi.crescer.controller.pedido;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoFinalizarController {

	private PedidoService pedidoService;

	@Autowired
	public PedidoFinalizarController(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/cancelar", method = RequestMethod.POST)
	public ModelAndView cancelar(@ModelAttribute("pedido") PedidoDTO pedidoDTO,
									final RedirectAttributes redirectAttributes){
		pedidoService.cancelarPedido(pedidoDTO.getId());
		redirectAttributes.addFlashAttribute("sucesso", "Pedido cancelado com sucesso");
		return new ModelAndView("redirect:/pedidos");
	}
	
	@RequestMapping(path = "/encerrar", method = RequestMethod.POST)
	public ModelAndView encerrar(@ModelAttribute("pedido") PedidoDTO pedidoDTO,
									final RedirectAttributes redirectAttributes){
		try {
			pedidoService.retirarPedido(pedidoDTO.getId());
			redirectAttributes.addFlashAttribute("sucesso", "Pedido encerrado com sucesso");
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("sucesso", "O Pedido precisa estar PROCESSADO para ser encerrado");
		}

		return new ModelAndView("redirect:/pedidos");
	}
	
	@ModelAttribute("situacoes")
    public SituacaoPedido[] comboSituacoes() {
        return SituacaoPedido.values();
    }
	
	
}
