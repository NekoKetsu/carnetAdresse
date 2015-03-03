package servlets.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AdresseServiceLocal;
import beans.Adresse;

/**
 * Servlet implementation class ShowServelet
 */
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		log("doGet : " + pathInfo);
		display(request, response);
	}

	private void display(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String page = (String) request.getAttribute("page");
		
		RequestDispatcher rD = request.getRequestDispatcher("/WEB-INF/"+page+".jsp");
		rD.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		log("doPost : " + pathInfo);
		display(request, response);
	}

}
