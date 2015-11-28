package br.com.cwi.crescer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;

	@Autowired
	public PedidoService(PedidoDAO pedidoDAO) {
		this.pedidoDAO = pedidoDAO;
	}
	
	public List<PedidoDTO> listarPedidos(){
		List<Pedido> pedidos = pedidoDAO.listAll();
		List<PedidoDTO> dtos = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			dtos.add(PedidoMapper.toDTO(pedido));
		}
		return dtos;
	}
	
}
