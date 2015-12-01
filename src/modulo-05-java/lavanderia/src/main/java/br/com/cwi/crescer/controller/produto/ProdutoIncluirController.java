package br.com.cwi.crescer.controller.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.dto.MaterialDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.dto.ServicoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoIncluirController {
	
	private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;
	
	@Autowired
	 public ProdutoIncluirController(ProdutoService produtoService, MaterialService materialService, ServicoService servicoService) {
		this.produtoService = produtoService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}

	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/incluir", method = RequestMethod.GET)
    public ModelAndView incluir() {
        return new ModelAndView("produto/novo", "produto", new ProdutoDTO());
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@Valid @ModelAttribute("produto") ProdutoDTO produtoDTO,
									BindingResult result,
									final RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()){
			return new ModelAndView("produto/novo");
		}
		
		if(produtoService.incluir(produtoDTO)){
			redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		}else{
			redirectAttributes.addFlashAttribute("sucesso", "Produto já existente");
		}
		return new ModelAndView("redirect:/produtos/incluir");
		
    }
	
	@ModelAttribute("materiais")
	public List<MaterialDTO> comboMateriais(){
		return materialService.listarMateriais();
	}
	
	@ModelAttribute("servicos")
	public List<ServicoDTO> comboServicos(){
		return servicoService.listarMateriais();
	}
	
}
