package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class ServicoDao {

	public void add(Servico servico) throws SQLException{
		
		try(Connection conn = new ConnectionFactory().getConnection()){
			String sql = "SELECT";
			PreparedStatement statement = conn.prepareStatement(sql);
		}
	}
	
}
