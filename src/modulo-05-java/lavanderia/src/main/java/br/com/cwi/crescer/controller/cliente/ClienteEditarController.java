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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Cidade;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.service.CidadeService;
import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteEditarController {
	
	
	private ClienteService clienteService;
	private CidadeService cidadeService;

	@Autowired
	public ClienteEditarController(ClienteService clienteService, CidadeService cidadeService) {
		this.clienteService = clienteService;
		this.cidadeService = cidadeService;
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
	
	@ModelAttribute("cidades")
    public List<Cidade> comboCidades() {
        return cidadeService.listar();
    }
	
	@ModelAttribute("situacoes")
    public SituacaoCliente[] comboSituacoes() {
        return SituacaoCliente.values();
    }
	
}
