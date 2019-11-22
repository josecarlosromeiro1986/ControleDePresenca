package br.com.controledepresenca.mvc.view.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controledepresenca.mvc.model.crud.DataSource;
import br.com.controledepresenca.mvc.model.persistent_object.POParticipante;




/**
 * Servlet implementation class RelatorioPalestra
 */
@WebServlet("/relatorioPalestra")
public class RelatorioPalestra extends HttpServlet {

	private static final long serialVersionUID = 1L;       

	public RelatorioPalestra() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}
	public List<POParticipante> findAll() throws SQLException{

		List<POParticipante> listar = new ArrayList<>();
		String sql = "select codigo, nome from participante";
		
		Connection conn = DriverManager.getConnection("localhost","root" , "");
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		while(resultSet.next()) {
			int codigo = resultSet.getInt("codigo");
			String nome = resultSet.getString("nome");
			
			POParticipante participante = new POParticipante(codigo, nome);
			listar.add(participante);
		}
		return listar;
		
		
	}
	
	
}
