package br.com.cwi.model;

public class Pedido extends BaseModel{
	
	Long idCliente;
	
	String dsPedido;
	
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDsPedido() {
		return dsPedido;
	}

	public void setDsPedido(String dsPedido) {
		this.dsPedido = dsPedido;
	}
}
