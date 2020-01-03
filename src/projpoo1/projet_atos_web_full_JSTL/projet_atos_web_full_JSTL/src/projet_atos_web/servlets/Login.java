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

import projet_atos_web.app.ListeUtilisateur;
import projet_atos_web.app.Utilisateur;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = { 
		"/Login"
},
		initParams = { 
				@WebInitParam(name = "contenu", value = "/WEB-INF/JSP")
		})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher(getInitParameter("contenu")
						+"/Menu/FormLogin.jsp") ;
	    
	     // redirection de la requête vers cette ressource
	    requestDispatcher.forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = null;
		HttpSession session = request.getSession(true);
		ListeUtilisateur utilisateurs = 
				new ListeUtilisateur();
		for (Utilisateur utilisateur : 
			utilisateurs.getUtilisateurs()) {
			if ((utilisateur.getIdentifiant().equals(
					request.getParameter("login")) && 
					(utilisateur.getMdp().equals(request.getParameter("mdp"))))) {
				requestDispatcher =
						request.getRequestDispatcher("Menu");
				session.setAttribute("Login", 
						utilisateur.getIdentifiant());
				requestDispatcher.forward(request, response);
				return;
			}
		}
		doGet(request, response);	
	}
}
