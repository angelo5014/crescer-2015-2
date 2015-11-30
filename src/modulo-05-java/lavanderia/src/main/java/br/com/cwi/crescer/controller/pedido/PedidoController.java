package br.com.cwi.crescer.controller.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.service.ClienteService;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.pedido.PedidoService;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {

	private PedidoService pedidoService;
	private ItemService itemService;
	private ClienteService clienteService;

	@Autowired
	public PedidoController(PedidoService pedidoService, ItemService itemService, ClienteService clienteService) {
		this.pedidoService = pedidoService;
		this.itemService = itemService;
		this.clienteService = clienteService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("pedido/lista", "pedidos", pedidoService.listarPedidos());
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
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/cancelar", method = RequestMethod.POST)
	public ModelAndView cancelar(@ModelAttribute("pedido") PedidoDTO pedidoDTO){
		pedidoService.cancelarPedido(pedidoDTO.getId());
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

	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
	public ModelAndView incluir(){
		return new ModelAndView("pedido/novo", "pedido", new PedidoDTO());
	}
	
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("pedido") PedidoDTO pedidoDTO,
											BindingResult result,
											final RedirectAttributes redirectAttributes){
		Long id = pedidoService.incluir(pedidoDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + id);
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
	
	@RequestMapping(path = "/buscar", method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam Map<String, String> param){
		List<PedidoDTO> dtos = new ArrayList<>();
		if(param.containsKey("cpf")){
			dtos = pedidoService.procurarPorCpf(param.get("cpf"));
		}else {
			dtos = pedidoService.procurarPorSituacao(param.get("situacao"));
		}
		
		return new ModelAndView("pedido/lista", "pedidos", dtos);
	}
	
	@ModelAttribute("clientes")
    public List<ClienteDTO> comboClientes() {
        return clienteService.listarClientes();
    }
	
	@ModelAttribute("situacoes")
    public SituacaoPedido[] comboSituacoes() {
        return SituacaoPedido.values();
    }
	
}
