package projet_atos_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import projet_atos_web.app.*;

/**
 * Servlet implementation class TraitementPersonne
 */
@WebServlet(urlPatterns = { 
		"/TraitementPersonne"
},
		initParams = { 
				@WebInitParam(name = "contenu", value = "/WEB-INF/JSP")
		})
public class TraitementPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TraitementPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		Personne p = new Personne();
		ListePersonne lp = null;
		
		if(session.getAttribute("listepersonne") == null) {
			lp = new ListePersonne();
			session.setAttribute("listepersonne", lp );
		}
		else
		{
			lp =  (ListePersonne) session.getAttribute("listepersonne");
		}
		
		if(request.getParameter("nom") != null ) {
			p.setNom(
					request.getParameter("nom"));
		}
		
		if(request.getParameter("prenom") != null ) {
			p.setPrenom(
					request.getParameter("prenom"));
			
		}
		lp.add(p);
		session.setAttribute("listepersonne", lp );
		session.setAttribute("personne", p );
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher(getInitParameter("contenu")+"/metier/AfficheListePersonnes.jsp") ;
	    
	     // redirection de la requête vers cette ressource
	    requestDispatcher.forward(request, response) ;
	}

}
