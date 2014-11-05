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
			String filename = DEFAULT_FILE_NAME;
			System.out.println(filename);
			TaskBook tb = gson.fromJson(new FileReader(
					filename), TaskBook.class);
			System.out.println(tb.getPersonList());
			Print(tb,out,filename,task);
		}catch(FileNotFoundException e){
			out.println("<html><head><title>Oh, oh...</title></head><body><h1>Lo sentimos. Tenemos un problema con el fichero,"
					+ "contacte con el desarrollador para más información</h1></body></html>");
		}
	}
	
	static void Print(TaskBook tb, PrintWriter out,String taskb, String filter) {
		out.println("<html><head><title>IT WORKS!!!</title></head>"
				+ "<body><h1>Estas mirando el libro de tareas "+taskb+" metido en el "+filter+"</h1>");
		String persona="";
		for (Person person : tb.getPersonList()) {
			out.println("HA ENTRADO!!");
			persona+="Person ID: " + person.getId()+"\n"
					+ "Name: " + person.getName()+"\n";
			if (person.hasEmail()) {
				persona+="  E-mail address: " + person.getEmail();
			}
			out.println("<div>"+persona+"</div><br>Listado de tareas:<br><div>");
			for (Task task : person.getPhoneList()) {
				switch (task.getType()) {
				case PERSONAL:
					out.print("  Personal task #: ");
					break;
				case HOME:
					out.print("  Home task #: ");
					break;
				case WORK:
					out.print("  Work task #: ");
					break;
				}
				out.println(task.getTitle()+"\n</div>");
			}
		}
		out.println("Acaba ya...");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
