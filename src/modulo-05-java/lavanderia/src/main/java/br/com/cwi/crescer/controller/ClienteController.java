package br.com.cwi.crescer.controller;

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

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	
	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientesAtivos());
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@RequestMapping(path="/editar/{id}", method = RequestMethod.GET)
	public ModelAndView exibirEdit(@PathVariable("id") Long id){
		return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.POST)
	public ModelAndView exibirEdit(ClienteDTO clienteDTO){
		clienteService.atualizar(clienteDTO);
		return new ModelAndView("redirect:/clientes");
	}
	
	@RequestMapping(path = "/novo", method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("cliente/novo", "cliente", new ClienteDTO());
    }
	
	@RequestMapping(path = "/novo", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("cliente") ClienteDTO dto,
    							BindingResult result,
    							final RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()){
			return new ModelAndView("cliente/novo");
		}
		
        clienteService.incluir(dto);
        return new ModelAndView("redirect:/clientes");
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
	
	@ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
}