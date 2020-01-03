package gestionWebPersonne.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import gestionWebPersonne.classes.Personne;

/**
 * Servlet implementation class MenuController
 */
@WebServlet("/MenuController")
public class MenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String param = request.getParameter("choix");
		RequestDispatcher rd = null;
		if (param != null) {
			switch (param) {
			case "1":
				rd = request.getRequestDispatcher("WEB-INF/JSP/creer.jsp");
				break;
			case "2":
				rd = request.getRequestDispatcher("WEB-INF/JSP/afficher.jsp");
				break;

			case "3":
				rd = request.getRequestDispatcher("WEB-INF/JSP/supprimer.jsp");
				break;

			default:
				rd = request.getRequestDispatcher("/index.jsp");

				break;
			}
		} else {
			rd = request.getRequestDispatcher("/index.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append(request.getParameter("nom"));

		if (request.getParameter("nom") != null && request.getParameter("prenom") != null
				&& request.getParameter("age") != null) {
			HttpSession session = request.getSession();
			Personne p = new Personne();
			p.setNom(request.getParameter("nom"));
			p.setPrenom(request.getParameter("prenom"));
			p.setAge(Integer.valueOf(request.getParameter("age")));
			session.setAttribute("mapersonne", p);
			
			ListPersonne lp = new Map<Integer, Personne>(map);

			RequestDispatcher rq = request.getRequestDispatcher("/index.jsp");
			rq.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/JSP/creer.jsp");	
			rd.forward(request, response);
			}
	}
}
