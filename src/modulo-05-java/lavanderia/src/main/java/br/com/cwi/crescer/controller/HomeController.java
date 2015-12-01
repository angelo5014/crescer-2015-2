package br.com.cwi.crescer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String Index(Model model) {
		String mensagem = "Bem vindo, Lavanderia Crescer";
		model.addAttribute("mensagem", mensagem);
		
		return "Index";
	}
	
}
