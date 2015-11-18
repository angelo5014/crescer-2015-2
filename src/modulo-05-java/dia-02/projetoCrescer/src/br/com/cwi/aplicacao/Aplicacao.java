package br.com.cwi.aplicacao;
import java.sql.SQLException;
import java.util.List;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.model.Cliente;

public class Aplicacao {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setId(1L);
		cliente.setNmCliente("Angelo");
		cliente.setNrCpf("666");
		
		ClienteDao clienteDao = new ClienteDao();
		
		try {
			clienteDao.add(cliente);
			

			List<Cliente> list = clienteDao.listAll();
			
			for(Cliente clienteL : list){
				System.out.println(clienteL.getNmCliente());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
