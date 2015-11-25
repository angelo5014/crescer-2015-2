package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.CidadeDAO;
import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.domain.Cliente;
import br.com.cwi.crescer.domain.Cliente.SituacaoCliente;
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
	
	public List<ClienteDTO> listarClientesAtivos() {
		List<Cliente> clientes = clienteDAO.listAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		for (Cliente cliente : clientes) {
			if(cliente.getSituacao() == SituacaoCliente.ATIVO)
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
	
	
	
	public void incluir(ClienteDTO clienteDTO){
		Cliente entity = ClienteMapper.getNewEntity(clienteDTO);
		entity.setCidade(cidadeDAO.findById(clienteDTO.getIdCidade()));
		entity.setSituacao(SituacaoCliente.ATIVO);
		clienteDAO.save(entity);
	}
	
	public void inativar(Long id){
		Cliente entity = clienteDAO.findById(id);
		entity.setSituacao(SituacaoCliente.INATIVO);
		clienteDAO.save(entity);
	}
	
	public void deletar(ClienteDTO clienteDTO) {
		clienteDAO.remove(clienteDTO.getId());
	}
	
}
