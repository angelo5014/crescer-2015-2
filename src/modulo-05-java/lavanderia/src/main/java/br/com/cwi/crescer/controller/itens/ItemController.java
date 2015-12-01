package br.com.cwi.crescer.controller.itens;

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

import br.com.cwi.crescer.dto.ItemDTO;
import br.com.cwi.crescer.dto.MaterialDTO;
import br.com.cwi.crescer.dto.ServicoDTO;
import br.com.cwi.crescer.service.ItemService;
import br.com.cwi.crescer.service.MaterialService;
import br.com.cwi.crescer.service.ServicoService;

@Controller
@RequestMapping(path = "/itens")
public class ItemController {
	
	private ItemService itemService;
	private MaterialService materialService;
	private ServicoService servicoService;

	@Autowired
	public ItemController(ItemService itemService, MaterialService materialService, ServicoService servicoService) {
		this.itemService = itemService;
		this.materialService = materialService;
		this.servicoService = servicoService;
	}
	
	@RequestMapping(path = "/incluir/{id}", method = RequestMethod.GET)
	public ModelAndView incluir(@PathVariable("id") Long id){
		return new ModelAndView("item/novo", "item", new ItemDTO(id));
	}
	
	@RequestMapping(path = "/incluir", method = RequestMethod.POST)
	public ModelAndView incluir(@Valid @ModelAttribute("item") ItemDTO itemDTO,
								BindingResult result,
								final RedirectAttributes redirectAttributes){
		if(result.hasErrors()){
			return new ModelAndView("item/novo");
		}
		
		
		itemService.inserirItem(itemDTO);
		return new ModelAndView("redirect:/pedidos/editar/" + itemDTO.getIdPedido());
	}
	
	@RequestMapping(path = "/processar/{id}/{idPedido}", method = RequestMethod.GET)
	public ModelAndView processar(@PathVariable("id") Long id, @PathVariable("idPedido") Long idPedido){
		itemService.processarItem(id);
		return new ModelAndView("redirect:/pedidos/editar/ " + idPedido );
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
