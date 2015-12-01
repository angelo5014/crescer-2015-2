package br.com.cwi.crescer.controller.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cwi.crescer.domain.Produto.SituacaoProduto;
import br.com.cwi.crescer.dto.MaterialDTO;
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
	
	@RequestMapping(path = "/buscar", params = {"material", "servico"},method = RequestMethod.GET)
	public ModelAndView buscar(@RequestParam("material") Long idMaterial, @RequestParam("servico") Long idServico){
		return new ModelAndView("produto/lista", "produtos", produtoService.buscar(idMaterial, idServico));
	}
	
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
