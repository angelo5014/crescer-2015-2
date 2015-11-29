package br.com.cwi.crescer.controller.pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
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
	
	@ModelAttribute("situacoes")
    public SituacaoPedido[] comboSituacoes() {
        return SituacaoPedido.values();
    }
	
}
