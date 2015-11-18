package br.com.cwi.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
	void add(T t) throws SQLException;
	List<T> listAll() throws SQLException;
}
