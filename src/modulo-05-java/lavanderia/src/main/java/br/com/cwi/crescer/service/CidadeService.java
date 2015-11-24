package br.com.cwi.crescer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.domain.Cidade;

@Service
public class CidadeService {

	private CidadeDAO cidadeDAO;

	public CidadeService(CidadeDAO cidadeDAO){
		this.cidadeDAO = cidadeDAO;
	}
	
	public List<Cidade> listar() {
        return cidadeDAO.listAll();
    }
	
}
