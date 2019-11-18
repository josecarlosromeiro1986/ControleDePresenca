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
import br.com.controledepresenca.mvc.model.crud.DataSource;
import br.com.controledepresenca.mvc.model.persistent_object.POControle;

/**
 * Servlet implementation class SaidaServlet
 */
@WebServlet("/saidaservlet")
public class SaidaServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public SaidaServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pagina = "/saida.jsp";
		int codigo = Integer.parseInt(request.getParameter("codigo"));

		DataSource dataSource = new DataSource();		

		CRUDControle crudcontrole = new CRUDControle(dataSource);
		int idcontrole = crudcontrole.getcontrole(codigo);

		POControle controle = new POControle();
		controle.setIdParticipante(codigo);
		controle.setIdControle(idcontrole);
		
		crudcontrole.update(controle);

		try {
			dataSource.getConnection().close();
		} catch (SQLException ex) {
			System.out.println("Erro ao fechar conexão "+ex.getMessage());
			pagina = "/saida.jsp";
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(pagina);
		dispatcher.forward(request, response);
	}

}
