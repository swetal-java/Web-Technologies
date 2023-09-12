package controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.userdao;
import model.usermodel;

/**
 * Servlet implementation class usercontoller
 */
@WebServlet("/usercontoller")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024* 512)
public class usercontoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public usercontoller() {
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
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("register")) {
			usermodel um = new usermodel();
			String savePath = "C:\\Users\\Indian\\eclipse-workspace\\assign04-10\\src\\main\\webapp\\images";   
			File fileSaveDir=new File(savePath);
	        if(!fileSaveDir.exists()){
	            fileSaveDir.mkdir();
	        }
	        Part file1 = request.getPart("pimage");
		 	String fileName = extractfilename(file1);
		    file1.write(savePath + File.separator + fileName);
		    String filePath= savePath + File.separator + fileName ;
		    
		    String savePath2 = "C:\\Users\\Indian\\eclipse-workspace\\assign04-10\\src\\main\\webapp\\images";
	        File imgSaveDir=new File(savePath2);
	        if(!imgSaveDir.exists()){
	            imgSaveDir.mkdir();
	            }
	        um.setImage(fileName);
			um.setFname(request.getParameter("fname"));
			um.setLname(request.getParameter("lname"));
			um.setGender(request.getParameter("gender"));
			um.setContact(Long.parseLong(request.getParameter("contact")));
			um.setEmail(request.getParameter("email"));
			um.setPassword(request.getParameter("password"));
			userdao.insertdata(um);
			response.sendRedirect("login.jsp");
		}else if (action.equalsIgnoreCase("login")) {
			usermodel um = new usermodel();
			um.setEmail(request.getParameter("email"));
			um.setPassword(request.getParameter("password"));
			usermodel u  =userdao.logindata(um);
			HttpSession session = request.getSession();
			session.setAttribute("data", u);
			request.getRequestDispatcher("Homepage.jsp").forward(request, response);
		}else if(action.equalsIgnoreCase("edit")) {
			usermodel um = new usermodel();
			um.setFname(request.getParameter("fname"));
			um.setLname(request.getParameter("lname"));
			um.setContact(Long.parseLong(request.getParameter("contact")));
			um.setEmail(request.getParameter("email"));
			um.setGender(request.getParameter("gender"));
			
			um.setId(Integer.parseInt(request.getParameter("id")));
			userdao.updateuser(um);
			response.sendRedirect("Homepage.jsp");
		}
	}

}
