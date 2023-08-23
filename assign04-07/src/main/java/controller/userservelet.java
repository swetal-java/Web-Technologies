package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
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
			usermodel umodel = new usermodel();
			umodel.setFname(request.getParameter("fname"));
			umodel.setLname(request.getParameter("lname"));
			umodel.setContact(Long.parseLong(request.getParameter("contact")));
			umodel.setEmail(request.getParameter("email"));
			umodel.setGender(request.getParameter("gender"));
			umodel.setPassword(request.getParameter("password"));
			userdao.insertuser(umodel);
			request.setAttribute("msg", "Succesfully Registered..");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			usermodel umUsermodel = new usermodel();
			umUsermodel.setEmail(email);
			umUsermodel.setPassword(password);
			usermodel um = userdao.login(email, password);
			request.setAttribute("data", um);
			request.getRequestDispatcher("HomePage.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			usermodel umodel = new usermodel();
			umodel.setFname(request.getParameter("fname"));
			umodel.setLname(request.getParameter("lname"));
			umodel.setContact(Long.parseLong(request.getParameter("contact")));
			umodel.setEmail(request.getParameter("email"));
			umodel.setGender(request.getParameter("gender"));
			umodel.setPassword(request.getParameter("password"));
			userdao.updateuser(umodel);
			response.sendRedirect("HomePage.jsp");
		}
	}

}
