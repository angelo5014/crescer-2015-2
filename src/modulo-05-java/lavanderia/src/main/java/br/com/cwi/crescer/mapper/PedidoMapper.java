package br.com.cwi.crescer.mapper;

import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.dto.PedidoDTO;

public class PedidoMapper {

	public static PedidoDTO toDTO(Pedido entity) {
		PedidoDTO dto = new PedidoDTO();
		dto.setId(entity.getIdPedido());
		dto.setIdCliente(entity.getCliente().getIdCliente());
		dto.setNomeCliente(entity.getCliente().getNome());
		dto.setCpfCliente(entity.getCliente().getCpf());
		dto.setDataInclusao(entity.getDataInclusao());
		dto.setDataEntrega(entity.getDataEntrega());
		dto.setValorBruto(entity.getValorBruto());
		dto.setValorDesconto(entity.getValorDesconto());
		dto.setValorFinal(entity.getValorFinal());
		dto.setSituacao(entity.getSituacao().toString());
		return dto;
	}
	
}
