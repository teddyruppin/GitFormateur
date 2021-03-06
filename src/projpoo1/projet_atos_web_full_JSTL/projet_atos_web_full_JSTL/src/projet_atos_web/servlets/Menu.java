package projet_atos_web.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.atos.englishbattle.service.JoueurService;
import net.atos.englishbattle.service.NiveauService;
import net.atos.englishbattle.service.impl.JoueurServiceImpl;
import net.atos.englishbattle.service.impl.NiveauServiceImpl;

/**
 * Servlet implementation class Menu
 */
/**
@WebServlet(
		urlPatterns = { 
				"/Menu", 
				"/Home"
		}, 
				initParams = { 
						@WebInitParam(name = "contenu", value = "/WEB-INF/JSP")
				})
**/
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
        super();
        // TODO Auto-generated constructor stub
        
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		RequestDispatcher requestDispatcher = null;
		if(session.getAttribute("Login") == null)
		{
			response.sendRedirect(getServletContext().
					getContextPath()+"/Login");
			return;
		}
		
		if(request.getParameter("choix") == null)
				requestDispatcher = request.getRequestDispatcher(
						getInitParameter("contenu")+"/Menu/Menu.jsp") ;
		else
		{
			int choix = Integer.parseInt(request.getParameter("choix"));
			switch (choix) {
				case 1: requestDispatcher = 
						request.getRequestDispatcher("/DemandeInfo") ;
						break;
				case 2: requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("contenu")+"/metier/InfoPersonne.jsp") ;
						break;
				case 3: requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("contenu")+"/metier/SaisiePersonne.jsp") ;
						break;
				case 4: requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("contenu")+"/metier/AfficheListePersonnes.jsp") ;
						break;
				case 50:
						JoueurService joueurService = new JoueurServiceImpl();
						NiveauService niveauService = new NiveauServiceImpl();
						session.setAttribute("SjoueurService", joueurService );
						session.setAttribute("SniveauService", niveauService );
						requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("battle")+"/gjoueurs.jsp") ;
						break;
				case 51: 
						NiveauService niveauService1 = new NiveauServiceImpl();
						session.setAttribute("SniveauService", niveauService1 );
						requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("battle")+"/gniveaux.jsp") ;
						break;
				case 52: requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("battle")+"/gverbes.jsp") ;
						break;
				case 53: requestDispatcher = 
						request.getRequestDispatcher(getInitParameter("battle")+"/gparties.jsp") ;
						break;
	
				default:
					requestDispatcher = request.getRequestDispatcher(getInitParameter("contenu")+"/Menu/Menu.jsp") ;
					break;
				}
			
		}
	     // redirection de la requ�te vers cette ressource
	    requestDispatcher.forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
