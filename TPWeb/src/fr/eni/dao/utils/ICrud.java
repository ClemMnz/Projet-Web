package fr.eni.dao.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICrud<T> 
{
	boolean Create(T item);
	List<T> Get();
	T Get(int id);
	boolean Update(T item);
	boolean Delete(int id);
	boolean Delete(T item);
	T itemBuilder(ResultSet rs) throws SQLException;
}
