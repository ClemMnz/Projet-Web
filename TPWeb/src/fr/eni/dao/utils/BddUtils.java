package fr.eni.dao.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BddUtils 
{
	public static Connection getConnexion() throws SQLException
	{
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		return  DriverManager.getConnection("jdbc:sqlserver://localhost;databasename=GestionFormation;user=sa;password=Pa$$w0rd");
	}
}
