package fr.eni.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.dao.StagiaireDao;
import fr.eni.model.Formation;
import fr.eni.model.Stagiaire;
import fr.eni.utils.MonLogger;

/**
 * Servlet implementation class AjouterStagiaireServlet
 */
public class AjouterStagiaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = MonLogger.getLogger(this.getClass().getSimpleName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AjouterStagiaireServlet() {
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
		List<Stagiaire> liste = null;
		StagiaireDao stagiaire = new StagiaireDao();
		RequestDispatcher rd = null;

		logger.info("Récupération liste"+ liste);
		
		if ("add".equals(request.getParameter("action"))) {
			logger.info("add");
			request.setAttribute("ajout", true);
			rd = getServletContext().getRequestDispatcher("/AddUpdateStagiaire.jsp");
			rd.forward(request, response);

			logger.info("fin add");
		}
		if ("delete".equals(request.getParameter("action"))) {
			logger.info("delete");
			int id = Integer.parseInt(request.getParameter("id"));
			stagiaire.Delete(id);
		}
		if ("update".equals(request.getParameter("action"))) {
			logger.info("update");
			Stagiaire stagiaireAModifier = stagiaire.Get(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("stagiaireAModifier", stagiaireAModifier);
			request.setAttribute("ajout", false);
			rd = getServletContext().getRequestDispatcher("/AddUpdateStagiaire.jsp");
			rd.forward(request, response);
			logger.info("fin update");
		}
		if ("Modifier".equals(request.getParameter("bouton"))) {
			logger.info("Modifier");
			Stagiaire stagiaireAModifier = stagiaire.Get(Integer.parseInt(request.getParameter("id")));
			stagiaireAModifier.setNom(request.getParameter("nom"));
			stagiaireAModifier.setPrenom(request.getParameter("prenom"));
			stagiaireAModifier.setMail(request.getParameter("mail"));
			stagiaireAModifier.setMotDePasse(request.getParameter("motDePasse"));
			stagiaire.Update(stagiaireAModifier);
			logger.info("fin Modifier");
			rd = getServletContext().getRequestDispatcher("/AffichageStagiaires.jsp");
		}
		if ("Ajouter".equals(request.getParameter("bouton"))) {
			logger.info("ajouter");
			Stagiaire stag = new Stagiaire();
			stag.setNom(request.getParameter("nom"));
			stag.setPrenom(request.getParameter("prenom"));
			stag.setMail(request.getParameter("mail"));
			stag.setMotDePasse(request.getParameter("motDePasse"));
			stagiaire.Create(stag);
		}
		liste = stagiaire.Get();
		request.setAttribute("stagiaires", liste);
		rd = getServletContext().getRequestDispatcher("/AffichageStagiaires.jsp");
		rd.include(request, response);
		logger.exiting(this.getClass().getSimpleName(), "FIN doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
