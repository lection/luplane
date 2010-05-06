package plane;

import java.io.IOException;
import javax.servlet.http.*;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class Gae_planeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		UserService service = UserServiceFactory.getUserService();
		User user = service.getCurrentUser();
		if(user != null){
			resp.getWriter().println("<html><head><title>Hello, world</title></head><body>Hello, world. <h3>"
					+user.getEmail()+"</h3></body></html>");
		}else{
			System.out.println(req.getRequestURI());
			resp.sendRedirect(service.createLoginURL(req.getRequestURI()));
		}
	}
}
