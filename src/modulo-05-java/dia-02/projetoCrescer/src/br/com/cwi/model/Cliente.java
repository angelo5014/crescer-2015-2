package br.com.cwi.model;

public class Cliente {
	
	private long IdCliente;
	
	private String nmCliente;
	
	private String nrCpf;

	public long getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(long l) {
		IdCliente = l;
	}

	public String getNmCliente() {
		return nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}

	public String getNrCpf() {
		return nrCpf;
	}

	public void setNrCpf(String nrCpf) {
		this.nrCpf = nrCpf;
	}
	
}
