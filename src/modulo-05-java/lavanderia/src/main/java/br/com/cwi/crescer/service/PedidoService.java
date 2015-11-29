package br.com.cwi.crescer.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO, ClienteDAO clienteDAO) {
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
	}

	public PedidoDTO buscarPorId(Long id) {
		return PedidoMapper.toDTO(pedidoDAO.findById(id));
	}
	
	public Long incluir(PedidoDTO dto){
		Pedido pedido = new Pedido();
		pedido.setCliente(clienteDAO.findById(dto.getIdCliente()));
		pedido.setDataInclusao(new Date());
		pedido.setValorBruto(new BigDecimal("0"));
		pedido.setSituacao(SituacaoPedido.PENDENTE);
		return pedidoDAO.save(pedido).getIdPedido();
		//return PedidoMapper.toDTO(pedidoDAO.findById(pedidoDAO.save(pedido).getIdPedido()));
	}
	
	public List<PedidoDTO> procurarPorCpf(String cpf) {
		List<PedidoDTO> dtos = new ArrayList<>();
		try{
			List<Pedido> pedidos =  pedidoDAO.findByIdCliente(clienteDAO.findByCpf(cpf));
				for (Pedido pedido : pedidos) {
					dtos.add(PedidoMapper.toDTO(pedido));
				}
		}finally{
			return dtos;
		}
	}

	public List<PedidoDTO> procurarPorSituacao(String situacao) {
		List<Pedido> pedidos = new ArrayList<>();
		if(!situacao.equals("TODAS")){
			pedidos =  pedidoDAO.findBySituacao(Enum.valueOf(SituacaoPedido.class, situacao));
		}else{
			pedidos =  pedidoDAO.listAll();
		}	
		List<PedidoDTO> dtos = new ArrayList<>();
			for (Pedido pedido : pedidos) {
				dtos.add(PedidoMapper.toDTO(pedido));
			}
		return dtos;
	}

	public List<PedidoDTO> listarPedidos() {
		List<Pedido> pedidos = pedidoDAO.listAll();
		List<PedidoDTO> dtos = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			dtos.add(PedidoMapper.toDTO(pedido));
		}
		return dtos;
	}
	
	public void cancelarPedido(Long id){
		setSituacaoPedido(id, SituacaoPedido.CANCELADO);
	}
	
	public void retirarPedido(Long id) throws Exception{
		Pedido entity = pedidoDAO.findById(id);
		if(entity.getSituacao() == SituacaoPedido.PROCESSADO){
			setSituacaoPedido(id, SituacaoPedido.ENCERRADO);
		}else{
			throw new Exception("Somente pedidos já processados podem ser encerrados.");
		}
	}
	
	private void setSituacaoPedido(Long idPedido, SituacaoPedido situacao){
		Pedido entity = pedidoDAO.findById(idPedido);
		entity.setSituacao(situacao);
		
		pedidoDAO.save(entity);
	}

}
