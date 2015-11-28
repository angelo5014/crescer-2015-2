package br.com.cwi.crescer.controller.cliente;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
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
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientes());
	}
	
	@RequestMapping(path = "/buscar",params = "nome", method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam("nome") String nome){
		return new ModelAndView("cliente/lista", "clientes", clienteService.buscar(nome));
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/rest/{id}")
	public ClienteDTO buscarCliente(@PathVariable("id") Long id) {
	    return clienteService.buscarClientePorId(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path="/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id){
		return new ModelAndView("cliente/edita", "cliente", clienteService.buscarClientePorId(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path="/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("cliente") ClienteDTO clienteDTO,
									BindingResult result,
									final RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return new ModelAndView("cliente/edita");
		}
		
		clienteService.atualizar(clienteDTO);
		redirectAttributes.addFlashAttribute("sucesso", "Cliente editado com sucesso");
		return new ModelAndView("redirect:/clientes");
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
	
	@ModelAttribute("situacoes")
    public SituacaoCliente[] comboSituacoes() {
        return SituacaoCliente.values();
    }
}
