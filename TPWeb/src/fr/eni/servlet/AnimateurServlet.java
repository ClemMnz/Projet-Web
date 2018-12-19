package fr.eni.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.dao.AnimateurDao;
import fr.eni.dao.FormationDao;
import fr.eni.model.Animateur;
import fr.eni.model.Formation;
import fr.eni.utils.MonLogger;

/**
 * Servlet implementation class AnimateurServlet
 * Servlet qui sert à l'accès des animateurs
 */
public class AnimateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = MonLogger.getLogger(this.getClass().getSimpleName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnimateurServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.entering(this.getClass().getSimpleName(), "doGet");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = null;
		boolean isConnectedWithCookie = false;
		boolean authentifie= false;
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String isConnected = request.getParameter("stayConnected");
		AnimateurDao animateur = new AnimateurDao();

		Animateur anim = animateur.GetByMail(login);

		Cookie[] cookies = request.getCookies();
		Cookie gato = null;

		if (cookies != null) {

			String valeur = "";

			for (int i = 0; i < cookies.length; i++) {
				//connexion avec cookie info
				if ("info".equals(cookies[i].getName())) {
				    valeur = cookies[i].getValue();
					logger.info("Récuperation clé cookie : " + cookies[i].getName());
					logger.info("Récuperation  valeur cookie : " + valeur);
					if ( (login != null && password != null )|| valeur.equals("supercookie") ) {
						logger.info("2eme if");
						if (authentifie || (valeur.equals("supercookie")) ) {
							logger.info("Cookie , login et mdp OK");
							isConnectedWithCookie = true;
							
							/*if ("Sedeconnecter".equals(request.getParameter("bouton"))) {
								//if ("info".equals(cookies[i].getName())) {
									logger.info("début deconnexion");
									cookies[i].setMaxAge(0);
									response.addCookie(cookies[i]);
									 isConnectedWithCookie= false;
									rd = getServletContext().getRequestDispatcher("/AccesAnimateur.jsp");
									logger.info("fin deconnexion");
									
								}*/
								FormationDao dao = new FormationDao();
								List<Formation> liste = dao.Get();
								request.setAttribute("formations",liste);
								authentifie= true; 
							rd = getServletContext().getRequestDispatcher("/MenuAnimateur.jsp");
						
					}
						else{
						
						rd = getServletContext().getRequestDispatcher("/AccesAnimateur.jsp");
					}
				}else{
					
					rd = getServletContext().getRequestDispatcher("/AccesAnimateur.jsp");
				}
			}
		}
		}
		if (!isConnectedWithCookie) {

			logger.info("Cookie login et mdp KO");
			// CAS login & Mot de passe OK
			if (login != null && password != null) {
				if (login.equals(anim.getAdresseMail()) && password.equals(anim.getMotDePasse())) {
					logger.info(" début Utilisateur connecté avec cookie");
					// Le client veut rester connecté.
					if (isConnected != null) {
						// Alors je créé un cookie qui sera stocké chez le
						// client.
						logger.info("Création cookie");
						gato = new Cookie("info", "supercookie");
						gato.setMaxAge(365 * 3600 * 24);
						response.addCookie(gato);
						logger.info(" fin Utilisateur connecté avec cookie");
					}
					// Le client ne veut pas rester connecté.
					else {
						logger.info("Création cookie 2");
						gato = new Cookie("info", "");
						gato.setMaxAge(0);
						response.addCookie(gato);
						logger.info(" fin Utilisateur connecté avec cookie2");
					}
					
					authentifie= true;
					FormationDao dao = new FormationDao();
					List<Formation> liste = dao.Get();
					request.setAttribute("formations",liste);
					
					rd = getServletContext().getRequestDispatcher("/MenuAnimateur.jsp");
					
				} else if (login.equals(anim.getAdresseMail()) && !password.equals(anim.getMotDePasse())) {
					logger.info("erreur de mdp");
					request.setAttribute("error", "Vous avez fait une erreur de mot de passe.");
					rd = getServletContext().getRequestDispatcher("/Erreur/Erreur.jsp");
				}
			
			}
			else {
				
				rd = getServletContext().getRequestDispatcher("/AccesAnimateur.jsp");
			}

		}
		rd.forward(request, response);
		logger.info("fin forward animServlet");
		logger.exiting(this.getClass().getSimpleName(), "doGet");

	}

	/*
	 * if(login == null && password == null) { rd =
	 * getServletContext().getRequestDispatcher("/AccesAnimateur.jsp");
	 * isConnectedWithCookie=false; }
	 * 
	 * if(login != null && password != null) { {
	 * 
	 * 
	 * 
	 * 
	 * isConnectedWithCookie=false;
	 * 
	 * } else if(login.equals(anim.getAdresseMail()) &&
	 * password.equals(anim.getMotDePasse())) { //rd =
	 * getServletContext().getRequestDispatcher("/MenuAnimateur.jsp");
	 * HttpSession session = request.getSession();
	 * 
	 * 
	 * logger.info("fin animServlet"); isConnectedWithCookie= true; } }
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}