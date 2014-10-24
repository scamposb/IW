package servlets.todo;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/primeraPrueba" })
public class TodoServlet {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Metodo encargado de realizar el ListPeople
		 * @param req
		 * @param resp
		 * @throws ServletException
		 * @throws IOException
		 */
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {

			String algo = req.getParameter("algo");
			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<html><head><title>Hello!</title></head>"
					+ "<body><h1>Hello!</h1>Has escrito "+algo+"</body></html>");
		}
}
