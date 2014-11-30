package bigws.todows;

// import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.io.PrintWriter;
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
		case "listTasks":
			req.setAttribute("action", "listTasks");			
			break;
		case "removeTask":
			req.setAttribute("action", "removeTask");
			req.setAttribute("title", req.getParameter("nameT"));
			break;
		default:
			break;
		}
		rd.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String option = req.getServletPath();
		
		switch(option){
		case "addTask":
			RequestDispatcher rd = req.getRequestDispatcher("results.jsp");
			req.setAttribute("task", req.getParameter("task"));
			req.setAttribute("priotask", req.getParameter("priotask"));
			req.setAttribute("date", req.getParameter("date"));
			req.setAttribute("description", req.getParameter("description"));
			rd.forward(req, resp);
			break;
		default:
			break;
		}
	}
}
