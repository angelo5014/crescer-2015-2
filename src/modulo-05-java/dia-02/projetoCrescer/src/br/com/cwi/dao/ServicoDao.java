package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class ServicoDao implements BaseDao<Servico>{

	public void add(Servico servico) throws SQLException{
		
		try(Connection conn = new ConnectionFactory().getConnection()){
			String sql = "INSERT INTO Servico(idServico, dsServico) VALUES(?,?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, servico.getId());
			statement.setString(2, servico.getDsServico());
			statement.execute();
		}catch (SQLException e) {
			throw e;
		}
	}
	
	public List<Servico> listAll() throws SQLException{
		
		try (Connection conn = new ConnectionFactory().getConnection()){
			
			String sql = "SELECT idServico, dsServico FROM Servico";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			List<Servico> lista = new ArrayList<Servico>();
			
			while (resultSet.next()) {
				Servico ser = new Servico();
				ser.setId(resultSet.getLong("idServico"));
				ser.setDsServico(resultSet.getString("dsServico"));
				lista.add(ser);
			}
			
			return lista;
			
		} catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public void delete(Long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Servico findById(Long id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Servico t) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Servico> find(Servico t) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
