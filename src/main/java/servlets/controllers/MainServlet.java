package servlets.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Adresse;
import services.AdresseServiceLocal;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AdresseServiceLocal aSL = null;

	/**
	 * Default constructor.
	 */
	public MainServlet() {
		if(aSL == null)
			aSL = new AdresseServiceLocal();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pathInfo = request.getPathInfo();
		log("doGet : " + pathInfo);
		String page = "ShowList";
		ArrayList<String> erreurs = new ArrayList<String>();
		ArrayList<String> messages = new ArrayList<String>();
		ArrayList<Adresse> adresses = new ArrayList<Adresse>();
		adresses.addAll(aSL.getAdresses());

		if (pathInfo != null) {
			if (pathInfo.startsWith("/new")) {
				page = "ShowForm";
			} else if (pathInfo.startsWith("/delete/")) {
				try {
					int id = Integer.parseInt(pathInfo.replace("/delete/", ""));
					aSL.deleteAdresse(id);
					messages.add("Sppression de l'adresse d'id : " + id);
					adresses.clear();
					adresses.addAll(aSL.getAdresses());
				} catch (Exception e) {
					erreurs.add(e.getMessage());
				}
			} else if (pathInfo.startsWith("/show/")) {
				page += pathInfo;
				int id = Integer.parseInt(pathInfo.replace("/show/", ""));
				Adresse adresse = null;
				
				try {
					adresse = aSL.getAdresse(id);
					request.setAttribute("adresse", adresse);
					page = "ShowForm";
				} catch (Exception e) {
					erreurs.add(e.getMessage());
				}
				
			}
		}
		
		
		request.setAttribute("page", page);
		request.setAttribute("adresses", adresses);
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("messages", messages);
		log("Forwarding : " + page);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ShowServlet");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ArrayList<String> erreurs = new ArrayList<String>();
		ArrayList<String> messages = new ArrayList<String>();

		String pathInfo = request.getPathInfo();
		log("doPost : " + pathInfo);
		Map<String, String[]> parameters = request.getParameterMap();
		for (String s : parameters.keySet()) {
			String logs = s + " : ";
			for (String _s : parameters.get(s)) {
				logs += _s + ", ";
			}
			log(logs);
		}
		String annulation = request.getParameter("annulation");	
		boolean annuler =  annulation != null && "Annuler".equals(annulation);
		if (pathInfo != null && !annuler) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String tel = request.getParameter("tel");
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");
			String pays = request.getParameter("pays");
			
			if (pathInfo.startsWith("/add/")) {
				aSL.createAdresse(nom, prenom, tel, rue, codePostal, ville,
						pays);
				messages.add("Création d'une adresse");
			} else if (pathInfo.startsWith("/edit/")) {
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					aSL.updateAdresse(id, nom, prenom, tel, rue, codePostal,
							ville, pays);
					messages.add("Mise a jour de l'adresse d'id : " + id);
				} catch (Exception e) {
					erreurs.add(e.getMessage());
				}
			}
		}
		
		request.setAttribute("page", "ShowList");
		request.setAttribute("erreurs", erreurs);
		request.setAttribute("messages", messages);
		request.setAttribute("adresses", aSL.getAdresses());
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/ShowServlet");
		rd.forward(request, response);
	}
}
