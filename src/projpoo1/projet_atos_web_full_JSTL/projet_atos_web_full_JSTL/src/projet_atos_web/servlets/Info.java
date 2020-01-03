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

/**
 * Servlet implementation class Info
 */
@WebServlet(urlPatterns = { 
		"/DemandeInfo"
},
		initParams = { 
				@WebInitParam(name = "contenu", value = "/WEB-INF/JSP")
		})
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Test si la variable session Login existe sinon -> Login
		HttpSession session = request.getSession(true);
		if(session.getAttribute("Login") == null) 
		{
			response.sendRedirect(getServletContext().
					getContextPath()+"/Login");
			return;
		}
		
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher(getInitParameter("contenu")+"/Menu/Info.jsp") ;
	    
	     // redirection de la requête vers cette ressource
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
