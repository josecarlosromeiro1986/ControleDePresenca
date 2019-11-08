package br.com.controledepresenca.mvc.model.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource{

	private static DataSource instance;
	private Connection connection;
	private final String URL = "jdbc:mysql://localhost/exemplo_login?useTimezone=true&serverTimezone=UTC";
	private final String USERNAME = "root";
	private final String PASSWORD = "";


	private DataSource() {

		try {
			this.connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("certo");

		} catch (SQLException e) {
			 System.err.println("Erro conexao"+e.getMessage());
		}

	}

	public static DataSource getIstance() {
		if(DataSource.instance == null) {
			DataSource.instance = new DataSource();			
		}
		return DataSource.instance;
	}

	public Connection getConnection() {
		return this.connection;
	}
	
	public static void main(String[] args) {
		
		DataSource ds = new DataSource();
		ds.getConnection();
	}
}