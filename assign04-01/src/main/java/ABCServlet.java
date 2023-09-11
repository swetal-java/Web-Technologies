import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ABCServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context = getServletContext();
		ServletConfig config = getServletConfig();
		System.out.println("ConfigObject"+config);
		System.out.println("ContextObject"+ context);
		
		String email = config.getInitParameter("email"); 
		
		resp.getWriter().write("ABC servlet " + context.getInitParameter("shop") );
		
		resp.getWriter().write("ABC servlet Init Param " + email );
	}

}
