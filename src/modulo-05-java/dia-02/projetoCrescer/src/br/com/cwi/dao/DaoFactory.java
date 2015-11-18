package br.com.cwi.dao;

public class DaoFactory {
	
	public static ClienteDao createClienteDao(){
		return new ClienteDao();
	}
	
	public static ServicoDao createServicoDao(){
		return new ServicoDao();
	}
}
