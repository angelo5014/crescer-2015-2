package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;

public class ClienteDao implements BaseDao<Cliente> {

	public void add(Cliente cliente) throws SQLException{
		try (Connection conn = new ConnectionFactory().getConnection();){
			PreparedStatement statement = conn.prepareStatement(
					"INSERT INTO Cliente "
					+ "(idCliente, nmCliente, nrCpf)"
					+ " VALUES(?,?,?)");
			
			statement.setLong(1, cliente.getId());
			statement.setString(2, cliente.getNmCliente());
			statement.setString(3, cliente.getNrCpf());
			
			System.out.println(statement.execute());
			
			
		} catch (SQLException e) {
			throw e;
		}
	}
	public List<Cliente> listAll() throws SQLException{
		
		try (Connection conn = new ConnectionFactory().getConnection()){
			
			PreparedStatement statement = conn.prepareStatement(
					"SELECT idCliente,"
					+ " nmCliente,"
					+ " nrCpf FROM Cliente");
			
			ResultSet result = statement.executeQuery();
			
			List<Cliente> list = new ArrayList<Cliente>();
			
			while(result.next()){
				Cliente cliente = new Cliente();
				cliente.setId(result.getLong("idCliente"));
				cliente.setNmCliente(result.getString("nmCliente"));
				cliente.setNrCpf(result.getString("nrCpf"));
				list.add(cliente);
			}
			
			return list;
			
		}catch(SQLException e){
			throw e;
		}
	}
}
