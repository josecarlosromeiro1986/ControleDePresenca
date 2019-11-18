package br.com.controledepresenca.mvc.model.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataSource{
	
	private String hostname;
	private String username;
	private String password;
	private String database;
	private Connection connection;

	public DataSource() {

		try {
			this.hostname = "localhost";
			this.database = "controle_presenca";
			this.username = "root";
			this.password = "";
			String url = "jdbc:mysql://"+hostname+"/"+database+"?useTimezone=true&serverTimezone=UTC";
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			this.connection = DriverManager.getConnection(url, this.username, this.password);
			System.out.println("DataSource - Conectado");
		} catch (SQLException ex) {
			System.out.println("ERRO ao Conectar - "+ex.getMessage());
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
	
}