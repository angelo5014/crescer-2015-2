package br.com.cwi.crescer.controller.produto;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.MaterialDTO;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.dto.ServicoDTO;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ProdutoService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	private ProdutoService produtoService;
	private MaterialService materialService;
	private ServicoService servicoService;
	
	@Autowired
	 public ProdutoController(ProdutoService produtoService, MaterialService materialService, ServicoService servicoService) {
		this.produtoService = produtoService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar(){
		return new ModelAndView("produto/lista", "produtos", produtoService.listarProdutos());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path="/editar/{id}", method = RequestMethod.GET)
	public ModelAndView editar(@PathVariable("id") Long id) {
		return new ModelAndView("produto/edita", "produto", produtoService.buscarProdutoPorId(id));
	}
	
	@PreAuthorize("hasRole('ADMIN')")
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
		
		produtoService.incluir(produtoDTO);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
        return new ModelAndView("produto/novo", "produto", new ProdutoDTO());
    }
	
	@RequestMapping(path = "/buscar", params = {"material", "servico"},method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam("material") Long idMaterial, @RequestParam("servico") Long idServico){
		return new ModelAndView("produto/lista", "produtos", produtoService.buscar(idMaterial, idServico));
	}
	
	/*
	@ModelAttribute("materiais")
	public String[] comboMateriais(){
		List<MaterialDTO> dtos = materialService.listarMateriais();
		String[] materiais = new String[dtos.size()];
		for (int i = 0; i < dtos.size() ; i++) {
			materiais[i] = dtos.get(i).getDescricao();
		}
		return materiais;
	}*/
	
	@ModelAttribute("materiais")
	public List<MaterialDTO> comboMateriais(){
		return materialService.listarMateriais();
	}
	
	@ModelAttribute("servicos")
	public List<ServicoDTO> comboServicos(){
		return servicoService.listarMateriais();
	}
	
	@ModelAttribute("situacoes")
    public SituacaoProduto[] comboSituacoes() {
        return SituacaoProduto.values();
    }
	
}
