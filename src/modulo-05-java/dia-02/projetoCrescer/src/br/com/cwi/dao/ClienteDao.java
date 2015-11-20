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

	public void add(Cliente cliente) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection();) {
			
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO Cliente " 
							+ "(idCliente, nmCliente, nrCpf)" 
							+ " VALUES(cliente_seq.nextval,?,?)");

			statement.setString(1, cliente.getNmCliente());
			statement.setString(2, cliente.getNrCpf());

			statement.execute();

		} catch (SQLException e) {
			throw e;
		}
	}

	public List<Cliente> listAll() throws SQLException {

		try (Connection conn = new ConnectionFactory().getConnection()) {

			PreparedStatement statement = conn
					.prepareStatement("SELECT idCliente," 
									+ " nmCliente," 
									+ " nrCpf FROM Cliente");

			ResultSet result = statement.executeQuery();

			List<Cliente> list = new ArrayList<Cliente>();

			while (result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(result.getLong("idCliente"));
				cliente.setNmCliente(result.getString("nmCliente"));
				cliente.setNrCpf(result.getString("nrCpf"));
				list.add(cliente);
			}

			return list;

		} catch (SQLException e) {
			throw e;
		}
	}

	public void delete(Long id) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			String sql = "DELETE FROM Cliente WHERE idCliente = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw e;
		}
	}

	public void update(Cliente cliente) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {

			String sql = "UPDATE Cliente SET nmCliente=?, nrCpf=? WHERE idCliente=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, cliente.getNmCliente());
			statement.setString(2, cliente.getNrCpf());
			statement.setLong(3, cliente.getId());

			statement.execute();
		} catch (SQLException e) {
			throw e;
		}
	}

	public Cliente findById(Long id) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			Cliente cliente = new Cliente();

			String sql = "SELECT idCliente," + " nmCliente," + " nrCliente" + " FROM Cliente WHERE idCliente=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				cliente.setId(resultSet.getLong("idCliente"));
				cliente.setNmCliente(resultSet.getString("nmCliente"));
				cliente.setNrCpf(resultSet.getString("nrCpf"));
			} else {
				throw new RuntimeException("Registro não encontrado");
			}

			return cliente;
		} catch (Exception e) {
			throw e;
		}

	}
	
	public Cliente findByName(String name) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()){
			String sql = "SELECT idCliente," 
						+ " nmCliente," 
						+ " nrCpf" 
						+ " FROM Cliente WHERE nmCliente=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, name);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(resultSet.getLong("idCliente"));
				cliente.setNmCliente(resultSet.getString("nmCliente"));
				cliente.setNrCpf(resultSet.getString("nrCpf"));
				return cliente;
			}
			return null;
		} catch (SQLException e) {
			throw e;
		}
	}

	public List<Cliente> find(Cliente cliente) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			List<Cliente> lista = new ArrayList<Cliente>();
			List<Object> parameter = new ArrayList<Object>();
			
			StringBuilder builder = new StringBuilder();
			builder.append(" SELECT idCliente,");
			builder.append(" nmCliente,");
			builder.append(" nmCliente,");
			builder.append(" nrCliente");

			boolean hasWhere = false;

			if (cliente.getId() != null) {
				builder.append("WHERE idCliente=?");
				hasWhere = true;
				parameter.add(cliente.getId());
			}

			if (cliente.getNmCliente() != null) {
				if (hasWhere) {
					builder.append("AND nmCliente=?");
				} else {
					builder.append("WHERE nmCliente=?");
					hasWhere = true;
				}
				parameter.add(cliente.getNmCliente());
			}

			if (cliente.getNrCpf() != null) {
				if (hasWhere) {
					builder.append("AND nrCpf=?");
				} else {
					builder.append("WHERE nrCpf=?");
				}
				parameter.add(cliente.getNrCpf());
			}

			PreparedStatement statement = conn.prepareStatement(builder.toString());
			
			for (int i = 0; i < parameter.size(); i++) {
				statement.setObject(1+1, parameter.get(i));
			}
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Cliente cliente2 = new Cliente();
				cliente2.setId(resultSet.getLong("idCliente"));
				cliente2.setNmCliente(resultSet.getString("nmCliente"));
				cliente2.setNrCpf(resultSet.getString("nrCpf"));
				lista.add(cliente2);	
			}

			return lista;
		} catch (Exception e) {
			throw e;
		}
	}
}
