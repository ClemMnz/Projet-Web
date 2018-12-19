package fr.eni.dao.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.eni.utils.Settings;

public class PoolConnection {
	
	private Connection cnx = null;
	
	private static String url = null;
	
	
	
	public Connection getConnection() throws SQLException {
		try {
			//On charge les données du fichier de conf.
			String className = Settings.getSetting("class");
			String databaseUrl = Settings.getSetting("url");
			String user = Settings.getSetting("user");
			String pwd = Settings.getSetting("pwd");
			
			//On charge le driver
			Class.forName(className);
			
			url = databaseUrl + ";user=" + user + ";password=" + pwd;
			} catch (ClassNotFoundException e) {
				System.err.println("Erreur lors du chargement du driver : " + e.getMessage());
			}
		if(cnx == null || cnx.isClosed()) {
			cnx = DriverManager.getConnection(url);
		}
		
		return cnx;
	}
	
	public void closeConnection() {
		if(cnx != null) {
			try {
				cnx.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				cnx = null;
			}
		}
	}

}







