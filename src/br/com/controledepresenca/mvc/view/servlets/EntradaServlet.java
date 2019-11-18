package br.com.controledepresenca.mvc.view.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.controledepresenca.mvc.model.crud.CRUDControle;
import br.com.controledepresenca.mvc.model.crud.CRUDParticipante;
import br.com.controledepresenca.mvc.model.crud.DataSource;
import br.com.controledepresenca.mvc.model.persistent_object.POControle;

/**
 * Servlet implementation class EntradaServlet
 */
@WebServlet("/entradaservlet")
public class EntradaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public EntradaServlet() {
		super();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		String pagina = "/entrada.jsp";
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		
		DataSource dataSource = new DataSource();		
		
		CRUDParticipante crudparticipante = new CRUDParticipante(dataSource);
		int idPalestra = crudparticipante.getparticipante(codigo); 
		
		POControle controle = new POControle();
		controle.setIdParticipante(codigo);
		controle.setIdPalestra(idPalestra);
		
		CRUDControle crudcontrole = new CRUDControle(dataSource);
		crudcontrole.insert(controle);
		
		try {
			dataSource.getConnection().close();
		} catch (SQLException ex) {
			System.out.println("Erro ao fechar conexão "+ex.getMessage());
			pagina = "/entrada.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
