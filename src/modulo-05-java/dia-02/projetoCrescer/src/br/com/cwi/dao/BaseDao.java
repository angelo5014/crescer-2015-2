package br.com.cwi.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDao<T> {
	void add(T t) throws SQLException;
	void delete(Long id)throws SQLException;
	List<T> listAll() throws SQLException;
	T findById(Long id) throws SQLException;
	void update(T t) throws SQLException; 
	List<T> find(T t) throws SQLException;
}
