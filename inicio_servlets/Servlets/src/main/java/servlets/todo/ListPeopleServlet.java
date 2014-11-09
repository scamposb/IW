package servlets.todo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/listTasks" })
public class ListPeopleServlet extends HttpServlet {
	
	public final static String DEFAULT_FILE_NAME = "task_book.json";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String task = req.getParameter("task");
		Gson gson= new Gson();
		try{
			TaskBook tb = gson.fromJson(new FileReader(DEFAULT_FILE_NAME), TaskBook.class);
			//System.out.println(tb.getPersonList());
			Print(tb,out,DEFAULT_FILE_NAME,task);
		}catch(FileNotFoundException e){
			out.println(
				"<html>" +
				"<head>" + 
				"<title>Oh, oh...</title>" + 
				"</head>" +
				"<body>" + 
					"<h1>Lo sentimos. Tenemos un problema con el fichero," +
					"contacte con el desarrollador para mas informacion</h1>" + 
				"</body>"+
				"</html>");
		}
	}
	
	static void Print(TaskBook tb, PrintWriter out,String taskb, String filter) {
		out.println("<html>"+
				"<head>"+
				"<title>IT WORKS!!!</title>"+
				"</head>" +
				"<body>"+
					"<h1>Estas mirando el libro de tareas "+taskb+" metido en el "+filter+"</h1>");
		String persona="";
		for (Person person : tb.getPersonList()) {
			persona+="Person ID: " + person.getId()	+ "Name: " + person.getName();
			if (person.hasEmail()) {
				persona+="  E-mail address: " + person.getEmail();
			}
			for (Task task : person.getPhoneList()) {
				switch (task.getType()) {
				case PERSONAL:
					persona+="  Personal task #: ";
					break;
				case HOME:
					persona+="  Home task #: ";
					break;
				case WORK:
					persona+="  Work task #: ";
					break;
				}
				persona+=task.getTitle();
			}
			out.println("<div>"+persona+"</div>");
			persona="";
		}
		out.println("</body></html>");
 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
