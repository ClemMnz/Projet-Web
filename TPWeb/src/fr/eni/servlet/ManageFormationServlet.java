package fr.eni.servlet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.dao.FormationDao;
import fr.eni.model.Formation;
import fr.eni.utils.MonLogger;

/**
 * Servlet implementation class ManageServlet
 */
public class ManageFormationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Logger monLogger = MonLogger.getLogger(this.getClass().getSimpleName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageFormationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		monLogger.entering(this.getClass().getSimpleName(), "doGet");
		response.setCharacterEncoding("UTF-8");
		RequestDispatcher rd = null;
		List<Formation> liste = null;
		FormationDao formation = new FormationDao(); 
		
		monLogger.info("Récupération liste"+ liste);
		monLogger.info("début do get Manage");
		
		if("delete".equals(request.getParameter("action")))
		{
			monLogger.info("delete");
			int id = Integer.parseInt(request.getParameter("id"));
			formation.Delete(id);
		}
		if("update".equals(request.getParameter("action")))
		{
			monLogger.info("update");
			Formation formationAModifier = formation.Get(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("formationAModifier", formationAModifier);
			request.setAttribute("ajout", false);
			rd = getServletContext().getRequestDispatcher("/AddUpdateFormation.jsp");
			rd.forward(request, response);
			monLogger.info("fin update");
		}
		if("Modifier".equals(request.getParameter("bouton")))
		{
			monLogger.info("Modifier");
			Formation formationAModifier = formation.Get(Integer.parseInt(request.getParameter("id").trim()));
			formationAModifier.setLibelle(request.getParameter("libelle"));
			formationAModifier.setDescription(request.getParameter("description"));
			formation.Update(formationAModifier);
			monLogger.info("fin Modifier");
			rd = getServletContext().getRequestDispatcher("/ModifFormations.jsp");
		}
		if("add".equals(request.getParameter("action")))
		{
			monLogger.info("add");
			request.setAttribute("ajout", true);
			rd = getServletContext().getRequestDispatcher("/AddUpdateFormation.jsp");
			rd.forward(request, response);
			
			monLogger.info("fin add");
		}
		if("Ajouter".equals(request.getParameter("bouton")))
		{
			monLogger.info("ajouter");
			
			Formation format= new Formation(); 
			format.setLibelle(request.getParameter("libelle"));
			format.setDescription(request.getParameter("description"));
			formation.Create(format);
		}
		liste= formation.Get(); 
		request.setAttribute("formations", liste);
		
		rd= getServletContext().getRequestDispatcher("/ModifFormations.jsp");
			
		rd.include(request, response);
		monLogger.exiting(this.getClass().getSimpleName(), "doGet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
