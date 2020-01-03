package projet_atos_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.atos.englishbattle.business.Joueur;
import net.atos.englishbattle.business.Niveau;
import net.atos.englishbattle.service.impl.JoueurServiceImpl;
import net.atos.englishbattle.service.impl.NiveauServiceImpl;

/**
 * Servlet implementation class JoueursServlet
 */

public class JoueursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoueursServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		JoueurServiceImpl joueurService = null;
		NiveauServiceImpl niveauService =  null;
		RequestDispatcher requestDispatcher = null;
		Joueur joueur =  new Joueur();
		
		if (session.getAttribute("SjoueurService") == null || session.getAttribute("SniveauService") == null) 
			response.sendRedirect("Menu");
		
		joueurService = (JoueurServiceImpl) session.getAttribute("SjoueurService");
		niveauService = (NiveauServiceImpl) session.getAttribute("SniveauService");
		
	    if((request.getParameter("Pseudo") == null)
	    	|| (request.getParameter("Mdp") == null)
	    	|| (request.getParameter("Email") == null)
	    	|| (request.getParameter("Niveau") == null)) {
			response.sendRedirect("Menu");
			return;
	    }
	       
	    joueur.setEmail(request.getParameter("Email"));
	    joueur.setMotDePasse(request.getParameter("Mdp"));
	    joueur.setPseudo(request.getParameter("Pseudo"));
	    
	    for(Niveau niveau : niveauService.recupererNiveaux())
	    {
	    	if(niveau.getId() == Integer.parseInt(request.getParameter("Niveau"))) {
	    		joueur.setNiveau(niveau);
	    		break;
	    	}
	    }
	    	    
	    joueurService.ajouterJoueur(joueur);
	    
	    session.setAttribute("SjoueurService", joueurService);
	    	    
		requestDispatcher = 
		request.getRequestDispatcher(getInitParameter("battle")+"/gjoueurs.jsp") ;
		requestDispatcher.forward(request, response);
	}

}
