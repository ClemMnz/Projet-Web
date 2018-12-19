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

import fr.eni.dao.FormationDao;
import fr.eni.model.Formation;
import fr.eni.utils.MonLogger;

/**
 * Servlet implementation class RecupererFormationsServlet
 */
public class RecupererFormationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger = MonLogger.getLogger(this.getClass().getSimpleName());
	FormationDao formDao = new FormationDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecupererFormationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.entering(this.getClass().getSimpleName(), "doGet");
		response.setCharacterEncoding("UTF-8");
		Cookie[] cookies = request.getCookies();
		List<Formation> maListe= null; 
		RequestDispatcher rd =null; 
		maListe=formDao.Get();
		
		request.setAttribute("superliste", maListe); 
		rd=getServletContext().getRequestDispatcher("/ListeFormations.jsp");
		
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
