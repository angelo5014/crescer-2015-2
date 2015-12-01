package br.com.cwi.crescer.controller.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteRemoverController {
	
	
	private ClienteService clienteService;

	@Autowired
	public ClienteRemoverController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(path = "/remover/{id}", method = RequestMethod.GET)
	public ModelAndView exibirRemover(@PathVariable("id") Long id){
		return new ModelAndView("cliente/remover", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@RequestMapping(path = "/remover", method = RequestMethod.POST)
    public ModelAndView excluir(ClienteDTO dto, final RedirectAttributes redirectAttributes) {
		clienteService.inativar(dto.getId());
		redirectAttributes.addFlashAttribute("sucesso", "Removido com sucesso");
        return new ModelAndView("redirect:/clientes");
    }
	
}
