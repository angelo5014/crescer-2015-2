package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;

public class PedidoDao implements BaseDao<Pedido>{

	public void add(Pedido pedido) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection();) {
			PreparedStatement statement = conn
					.prepareStatement("INSERT INTO Pedido " 
							+ "(idPedido, idCliente, dsPedido)" 
							+ " VALUES(pedido_seq.nextval,?,?)");

			statement.setLong(1, pedido.getIdCliente());
			statement.setString(2, pedido.getDsPedido());

			statement.execute();

		} catch (SQLException e) {
			throw e;
		}
		
	}

	public void delete(Long id) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			String sql = "DELETE FROM Pedido WHERE idPedido = ?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw e;
		}
		
	}

	public List<Pedido> listAll() throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {

			PreparedStatement statement = conn
					.prepareStatement("SELECT idPedido," 
										+ " idCliente," 
										+ " dsPedido FROM Pedido");

			ResultSet result = statement.executeQuery();

			List<Pedido> list = new ArrayList<Pedido>();

			while (result.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(result.getLong("idPedido"));
				pedido.setIdCliente(result.getLong("IdCliente"));
				pedido.setDsPedido(result.getString("dsPedido"));
				list.add(pedido);
			}

			return list;

		} catch (SQLException e) {
			throw e;
		}
	}

	public Pedido findById(Long id) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {
			Pedido pedido = new Pedido();

			String sql = "SELECT idPedido," 
							 + " idCliente," 
							 + " dsPedido" 
							 + " FROM Pedido WHERE idPedido=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				pedido.setId(resultSet.getLong("idCliente"));
				pedido.setIdCliente(resultSet.getLong("IdCliente"));
				pedido.setDsPedido(resultSet.getString("dsPedido"));
			} else {
				throw new RuntimeException("Registro não encontrado");
			}

			return pedido;
		} catch (Exception e) {
			throw e;
		}
	}

	public void update(Pedido pedido) throws SQLException {
		try (Connection conn = new ConnectionFactory().getConnection()) {

			String sql = "UPDATE Pedido SET idCliente=?, dsPedido=? WHERE idPedido=?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, pedido.getIdCliente());
			statement.setString(2, pedido.getDsPedido());
			statement.setLong(3, pedido.getId());

			statement.execute();
		} catch (SQLException e) {
			throw e;
		}
		
	}
	
	public List<Pedido> listPedidoByIdCliente(Long id) throws Exception{
		List<Pedido> lista = new ArrayList<Pedido>();
		try (Connection conn = new ConnectionFactory().getConnection()) {
			

			String sql = "SELECT idPedido," 
							 + " idCliente," 
							 + " dsPedido" 
							 + " FROM Pedido WHERE idCliente=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, id);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(resultSet.getLong("idCliente"));
				pedido.setIdCliente(resultSet.getLong("IdCliente"));
				pedido.setDsPedido(resultSet.getString("dsPedido"));
				lista.add(pedido);
			}

			return lista;
		} catch (Exception e) {
			throw e;
		}
	}

	public List<Pedido> find(Pedido t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
