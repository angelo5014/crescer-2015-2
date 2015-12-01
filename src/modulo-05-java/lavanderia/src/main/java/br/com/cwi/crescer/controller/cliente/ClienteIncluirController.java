package br.com.cwi.crescer.controller.cliente;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteIncluirController {
	
	
	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteIncluirController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}

	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
    }
	
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(
    		@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO,
    		BindingResult result,
    		final RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()){
			return new ModelAndView("cliente/novo");
		}
		
        clienteService.incluir(clienteDTO);
        
        redirectAttributes.addFlashAttribute("sucesso", "Cliente criado com sucesso");
        
        return new ModelAndView("redirect:/clientes");
    }
	
	@ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
	
}
