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
public class ListServlet extends HttpServlet {
	
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
			Print(tb,out,DEFAULT_FILE_NAME,task);
		}catch(FileNotFoundException e){
			resp.sendError(406);
			resp.sendRedirect("error.html");
		}
	}
	
	static void Print(TaskBook tb, PrintWriter out,String taskb, String filter) {
		out.println("<html>"+
				"<head>"+
				"<title>List tasks</title>"+
				"</head>" +
				"<body>");
		if(filter.equals("")){
			/* Lista todas las tareas */
		out.println("<h1>Listado de todas las tareas</h1>");
		String persona="";
		for (Person person : tb.getPersonList()) {
			persona+="Person ID: " + person.getId()	+ " Name: " + person.getName();
			if (person.hasEmail()) {
				persona+=" (" + person.getEmail()+")";
			}
			for (Task task : person.getTaskList()) {
				switch (task.getType()) {
				case PERSONAL:
					persona+="<br>&nbsp;&nbsp;&nbsp;&nbsp;Personal task #: ";
					break;
				case HOME:
					persona+="<br>&nbsp;&nbsp;&nbsp;&nbsp;Home task #: ";
					break;
				case WORK:
					persona+="<br>&nbsp;&nbsp;&nbsp;&nbsp;Work task #: ";
					break;
				}
				persona+=task.getTitle();
			}
			out.println("<div>"+persona+"</div><br><br>");
			persona="";
		}
		}
		else{
			/* Lista las tareas que contienen la palabra insertada en filter */
			for(Person person : tb.getPersonList()){
				if(person.hasTasks()){					
					String personEmail="";
					if(!person.hasEmail()) personEmail="Email not found";
					else personEmail=person.getEmail();	
					for(Task task: person.getTaskList()){
						if(coincidences(filter,task)){	
							out.println("<h1>Task with coincidences</h1>");
							out.println("<div><b>Title: </b>"+task.getTitle()+"<br>");
							out.println("<b>Type: </b>"+task.getType()+"<br>");
							if(task.getDescription()!=null)
								out.println("<b>Description:  </b>"+task.getDescription()+"<br>");
							out.println("<b>Task's person: </b>"+person.getName()+" ("+personEmail+")<br></div>");
						}
					}
				}				
			}
		}
					
		out.println("</body></html>");
 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private static boolean coincidences(String filter, Task task){
		return (task.getTitle().contains(filter) || task.getDescription().contains(filter)
				|| task.getDate().equals(filter));
	}
}
