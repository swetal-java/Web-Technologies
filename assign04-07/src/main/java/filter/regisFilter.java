package filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/userservelet")
public class regisFilter implements Filter{
	

	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String contact = (String) request.getParameter("contact");
		
		RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
		if(fname.equals("") || fname.equals(null)) {
			request.setAttribute("fname", "First Name cant be null..");
			rd.forward(request, response);
		}
		
		if(lname.equals("") || lname.equals(null)) {
			request.setAttribute("lname", "Last Name cant be null..");
			rd.forward(request, response);
		}
		
		if(email.equals("") || email.equals(null)) {
			request.setAttribute("email", "First Name cant be null..");
			rd.forward(request, response);
		}
		
		if(password.equals("") || password.equals(null)) {
			request.setAttribute("password", "First Name cant be null..");
			rd.forward(request, response);
		}
		
		if(gender.equals("") || gender.equals(null)) {
			request.setAttribute("gender", "First Name cant be null..");
			rd.forward(request, response);
		}
		
		if(contact.equals("") || contact.equals(null)) {
			request.setAttribute("contact", "First Name cant be null..");
			rd.forward(request, response);
		}
		
		
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
}
