package fr.eni.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.utils.MonLogger;

/**
 * Servlet implementation class AffichageMenuServlet
 */
public class AffichageMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = MonLogger.getLogger(this.getClass().getSimpleName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AffichageMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null; 
		logger.entering(this.getClass().getSimpleName(), "doGet");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n" + 
				"<meta name=\"description\" content=\"\">\r\n" + 
				"<meta name=\"author\" content=\"\">\r\n" + 
				"<link rel=\"icon\" href=\"../../favicon.ico\">\r\n" + 
				"\r\n" + 
				"<title>TP Web-Accueil</title>\r\n" + 
				"\r\n" + 
				"<link href=\"themes/basique/bootstrap-theme.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"<link href=\"themes/basique/bootstrap.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"<link href=\"themes/basique/theme.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"	<nav class=\"navbar navbar-inverse navbar-fixed-top\">\r\n" + 
				"		<div class=\"container\">\r\n" + 
				"\r\n" + 
				"			<div id=\"navbar\" class=\"collapse navbar-collapse\">\r\n" + 
				"				<ul class=\"nav navbar-nav\">\r\n" + 
				"					<li class=\"active\"><a href=\"index.html\">Accueil</a></li>\r\n" + 
				"					<li><a href=\"formations.html\">Liste des formations</a></li>\r\n" + 
				"					<li><a href=\"animateur/accesAnimateur.html\">Accès\r\n" + 
				"							animateurs</a></li>\r\n" + 
				"					<li><a href=\"stagiaire/accesStagiaire.html\">Accès\r\n" + 
				"							stagiaires</a></li>\r\n" + 
				"				</ul>\r\n" + 
				"				<form class=\"navbar-form navbar-right\"\r\n" + 
				"					action=\"http://www.google.fr/search\">\r\n" + 
				"					<div class=\"form-group\">\r\n" + 
				"						<input type=\"text\" name=\"q\">\r\n" + 
				"					</div>\r\n" + 
				"					<button type=\"submit\" class=\"btn btn-success\">Rechercher</button>\r\n" + 
				"				</form>\r\n" + 
				"			</div>\r\n" + 
				"			<!--/.nav-collapse -->\r\n" + 
				"		</div>\r\n" + 
				"	</nav>");
		
		
		rd = getServletContext().getRequestDispatcher("Menu.jsp");
		rd.forward(request, response);
		
		logger.exiting(this.getClass().getSimpleName(), "doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
