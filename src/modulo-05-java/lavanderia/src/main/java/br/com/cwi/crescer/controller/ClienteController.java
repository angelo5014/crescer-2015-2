package br.com.cwi.crescer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	
	private ClienteService clienteService;

	@Autowired
	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@RequestMapping(path="/listar",method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("cliente/lista", "clientes", clienteService.listarClientes());
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ModelAndView exibir(@PathVariable("id") Long id){
		return new ModelAndView("cliente/exibe", "cliente", clienteService.)
	}
	
}
