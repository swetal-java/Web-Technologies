package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.usermodel;

/**
 * Servlet implementation class userservelet
 */
@WebServlet("/userservelet")
public class userservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userservelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			usermodel um = new usermodel();
			um.setFname(request.getParameter("fname"));
			um.setLname(request.getParameter("lname"));
			um.setContact(Long.parseLong(request.getParameter("contact")));
			um.setEmail(request.getParameter("email"));
			um.setGender(request.getParameter("gender"));
			request.setAttribute("data", um);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}
	}

}
