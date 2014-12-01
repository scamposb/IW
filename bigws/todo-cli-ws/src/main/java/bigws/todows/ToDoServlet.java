package bigws.todows;

// import javax.xml.ws.BindingProvider;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/addTask","/removeTask","/listTasks"})	
public class ToDoServlet extends HttpServlet{
 	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String option = req.getServletPath();
		RequestDispatcher rd = req.getRequestDispatcher("results.jsp");
		
		switch(option){
		case "/listTasks":
			req.setAttribute("action", option);
			break;
		case "/removeTask":
			req.setAttribute("action", option);
			req.setAttribute("title", req.getParameter("nameT"));
			break;
		default:
			req.setAttribute("action", "nothing");
			break;
		}
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String option = req.getServletPath();
		RequestDispatcher rd = req.getRequestDispatcher("results.jsp");
		
		switch(option){
		case "/addTask":
			req.setAttribute("action", option);
			req.setAttribute("task", req.getParameter("task"));
			req.setAttribute("priotask", req.getParameter("priotask"));
			req.setAttribute("date", req.getParameter("date"));
			req.setAttribute("description", req.getParameter("description"));
			break;
		default:
			req.setAttribute("action", "nothing");
			break;
		}
		rd.forward(req, resp);
	}
	
}
