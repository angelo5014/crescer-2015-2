package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cwi.crescer.dao.MaterialDAO;
import br.com.cwi.crescer.dao.ProdutoDAO;
import br.com.cwi.crescer.dao.ServicoDAO;
import br.com.cwi.crescer.domain.Produto;
import br.com.cwi.crescer.dto.ProdutoDTO;
import br.com.cwi.crescer.mapper.ProdutoMapper;

public class ProdutoService {
	
	private ProdutoDAO produtoDAO;
	private ServicoDAO servicoDAO;
	private MaterialDAO materialDAO;
	
	@Autowired
	public ProdutoService(ProdutoDAO produtoDAO, ServicoDAO servicoDAO, MaterialDAO materialDAO) {
		this.produtoDAO = produtoDAO;
		this.servicoDAO = servicoDAO;
		this.materialDAO = materialDAO;
	}
	
	public List<ProdutoDTO> listarProdutos() {
		List<Produto> produtos = produtoDAO.listAll();
		List<ProdutoDTO> produtoDTO = new ArrayList<>();
		for (Produto produto : produtos) {
			produtoDTO.add(ProdutoMapper.toDTO(produto));
		}
		return produtoDTO;
	}
	
}
