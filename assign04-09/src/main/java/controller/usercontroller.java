package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userdao;
import model.usermodel;
import services.mailservice;


/**
 * Servlet implementation class usercontroller
 */
@WebServlet("/usercontroller")
public class usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercontroller() {
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
	    	 String email = request.getParameter("email");
	    	 um.setName(request.getParameter("name"));
	    	 um.setContact(Long.parseLong(request.getParameter("contact")));
	    	 um.setPassword(request.getParameter("password"));
	    	 um.setEmail(request.getParameter("email"));
	    	 userdao.insertdata(um);
	    	 mailservice s = new mailservice();
	    	 Random random = new Random();
	    	 int num = random.nextInt(9999);
	    	 System.out.println(num);
	    	 s.sendMail(email, num);
	    	 request.setAttribute("otp", num);
	    	 request.getRequestDispatcher("otpverify.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("verifyotp")) {
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				response.sendRedirect("login.jsp");
			}else {
				request.setAttribute("msg", "Please Enter correct OTP..");
				request.getRequestDispatcher("otpverify.jsp").forward(request, response);
			}
		}else if(action.equalsIgnoreCase("login")) {
			String email = request.getParameter("email");
			boolean flag = userdao.chkemail(email);
			if(flag == true) {
				usermodel um = new usermodel();
				um.setEmail(request.getParameter("email"));
				um.setPassword(request.getParameter("password"));
				usermodel u1 = userdao.login(um);
				if(u1 == null) {
					request.setAttribute("msg2","Password is not correct");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("homepage.jsp").forward(request, response);
				}
			}
		}else if(action.equalsIgnoreCase("update")) {
			usermodel um = new usermodel();
			um.setId(Integer.parseInt(request.getParameter("id")));
			um.setName(request.getParameter("name"));
			um.setEmail(request.getParameter("email"));
			um.setContact(Long.parseLong(request.getParameter("contact")));
			userdao.updatadata(um);
			response.sendRedirect("homepage.jsp");
		}
	}

}
