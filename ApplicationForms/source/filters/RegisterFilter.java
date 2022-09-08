package filters;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class RegisterFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public RegisterFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String contact = request.getParameter("contact");
		if(contact.matches("[1-9]{1}[0-9]{9}"))
		{
			chain.doFilter(request, response);
		}
		else
		{
			PrintWriter out = response.getWriter();
			request.getRequestDispatcher("index.jsp").include(request, response);
			out.print("<center><span style='color:red'>!!!!!!INVALID CONTACT NUMBER</span></center>");
		}
	}
}
