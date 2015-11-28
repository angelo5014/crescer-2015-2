package br.com.cwi.crescer.controller.produto;

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

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.service.ProdutoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	ProdutoService produtoService;
	
	@Autowired
	 public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
	}
	
	@RequestMapping(path="/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id) {
		return new ModelAndView("produto/edita", "produto", produtoService.buscarProdutoPorId(id));
	}
	
	@RequestMapping(path="/editar", method = RequestMethod.POST)
	public ModelAndView editar(@Valid @ModelAttribute("produto") ProdutoDTO produtoDTO,
									BindingResult result,
									final RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return new ModelAndView("cliente/edita");
		}
		
		produtoService.atualizar(produtoDTO);
		redirectAttributes.addFlashAttribute("sucesso", "Produto alterdo com sucesso");
		return new ModelAndView("redirect:/produtos");
		
	}
	
	@ModelAttribute("situacoes")
    public SituacaoProduto[] comboSituacoes() {
        return SituacaoProduto.values();
    }
	
}
