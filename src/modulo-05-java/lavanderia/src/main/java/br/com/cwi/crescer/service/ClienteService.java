package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.dto.ClienteDTO;
import br.com.cwi.crescer.mapper.ClienteMapper;

@Service
public class ClienteService {
	
	private ClienteDAO clienteDAO;
	private CidadeDAO cidadeDAO;

	@Autowired
	public ClienteService(ClienteDAO clienteDAO, CidadeDAO cidadeDAO) {
		this.clienteDAO = clienteDAO;
		this.cidadeDAO = cidadeDAO;
	}

	public List<ClienteDTO> listarClientes() {
		List<Cliente> clientes = clienteDAO.listAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			clientesDTO.add(ClienteMapper.toDTO(cliente));
		}
		return clientesDTO;
	}
	
	public ClienteDTO buscarClientePorId(Long id){
		return ClienteMapper.toDTO(clienteDAO.findById(id));
	}
	
	public void atualizar(ClienteDTO clienteDTO) {
		Cliente cliente = ClienteMapper.merge(clienteDTO, clienteDAO.findById(clienteDTO.getId()));
		cliente.setCidade(cidadeDAO.findById(clienteDTO.getIdCidade()));
		clienteDAO.save(cliente);
	}
	
}
