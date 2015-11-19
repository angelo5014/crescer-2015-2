package br.com.cwi.dao;

public class DaoFactory {
	
	public static ClienteDao createClienteDao(){
		return new ClienteDao();
	}
	
	public static ServicoDao createServicoDao(){
		return new ServicoDao();
	}
	
	public static PedidoDao createPedidoDao() {
		return new PedidoDao();
	}
}
