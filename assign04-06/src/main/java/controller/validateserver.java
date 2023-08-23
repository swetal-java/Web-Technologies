package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.DocFlavor.STRING;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.env.IModule.IService;

/**
 * Servlet implementation class validateserver
 */
@WebServlet("/validateserver")
public class validateserver extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public validateserver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");

		boolean isfnamevalid = alphabet(fname);
		boolean islnamevalid = alphabet(lname);
		boolean isemailvalid = emailvalid(email);
		boolean iscontactvalid = contactvalid(contact);
		boolean ispasswordvalid = passwordvalid(password);
		
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        if (!isfnamevalid) {
	            out.println("<h2>Invalid First Name</h2>");
	        }if(!islnamevalid) {
	        	out.println("<h2>Invalid Last Name</h2>");
	        }if(!isemailvalid) {
	        	out.println("<h2>Invalid Email</h2>");
	        }if(!iscontactvalid) {
	        	out.println("<h2>Invalid Contact</h2>");
	        }if(!ispasswordvalid) {
	        	out.println("<h2>Invalid Password</h2>");
	        }
	        else {
	            out.println("<h2>Registration SuccesFull.</h2>");
	        }
	    }
	

	private boolean alphabet(String input) {
		return input.matches("[a-zA-Z]+");
	}
	
	private boolean emailvalid(String input) {
		return input.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
	}
	
	private boolean contactvalid(String input) {
		return input.matches("/^[0-9]+$/");
	}
	
	private boolean passwordvalid(String input) {
		return input.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%_&])[A-Za-z\\d@#$%_&]{8,}$");
	}
}
