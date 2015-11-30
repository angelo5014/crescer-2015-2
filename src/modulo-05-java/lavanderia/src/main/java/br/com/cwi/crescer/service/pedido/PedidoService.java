package br.com.cwi.crescer.service.pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cwi.crescer.dao.ClienteDAO;
import br.com.cwi.crescer.dao.PedidoDAO;
import br.com.cwi.crescer.domain.Item;
import br.com.cwi.crescer.domain.Item.SituacaoItem;
import br.com.cwi.crescer.domain.Pedido;
import br.com.cwi.crescer.domain.Pedido.SituacaoPedido;
import br.com.cwi.crescer.dto.PedidoDTO;
import br.com.cwi.crescer.mapper.PedidoMapper;

@Service
public class PedidoService {

	private PedidoDAO pedidoDAO;
	private ClienteDAO clienteDAO;
	private PedidoItemService pedidoItemService;
	private PedidoDescontoService pedidoDescontoService;
	
	@Autowired
	public PedidoService(PedidoDAO pedidoDAO, 
							ClienteDAO clienteDAO, 
							PedidoItemService pedidoItemService, 
							PedidoDescontoService pedidoDescontoService) {
		this.pedidoDAO = pedidoDAO;
		this.clienteDAO = clienteDAO;
		this.pedidoItemService = pedidoItemService;
		this.pedidoDescontoService = pedidoDescontoService;
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
	
	public void processandoPedido(Long id){
		setSituacaoPedido(id, SituacaoPedido.PROCESSANDO);
	}
	
	public void processarPedido(Long id) {
		processarItensPedido(id);
		setSituacaoPedido(id, SituacaoPedido.PROCESSADO);
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
	
	public void atualizarInformacoes(Long id){
		Pedido pedido = pedidoDAO.findById(id);
		
		pedido.setValorBruto(pedidoItemService.obterValorTotalDeItens(pedido));
		pedido.setDataEntrega(pedidoItemService.calcularDataEntrega(pedido));
		pedido.setValorDesconto(pedidoDescontoService.calcularDesconto(pedido));
		pedido.setValorFinal(pedido.getValorBruto().subtract(pedido.getValorDesconto()));
		pedido = verificarItensProcessados(pedido);
		
		pedidoDAO.save(pedido);
	}
	
	private Pedido verificarItensProcessados(Pedido pedido){
		
		int itensProcessados = 0;
		for (Item item : pedido.getItens()) {
			if(item.getSituacao() == SituacaoItem.PROCESSADO){
				itensProcessados++;
			}
		}
		pedido.setSituacao(itensProcessados == pedido.getItens().size() ?
				SituacaoPedido.PROCESSADO : pedido.getSituacao());	
		return pedido;
	}
	
	private void processarItensPedido(Long id){
		Pedido pedido = pedidoDAO.findById(id);
		for (Item item : pedido.getItens()) {
			item.setSituacao(SituacaoItem.PROCESSADO);
		}
		pedidoDAO.save(pedido);
	}

}
