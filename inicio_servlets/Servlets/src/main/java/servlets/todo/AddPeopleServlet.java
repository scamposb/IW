package servlets.todo;

import static servlets.todo.TaskType.DEFAULT;
import static servlets.todo.TaskType.HOME;
import static servlets.todo.TaskType.PERSONAL;
import static servlets.todo.TaskType.WORK;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/AddPerson" })
public class AddPeopleServlet extends HttpServlet{
	
	public final static String DEFAULT_FILE_NAME = "task_book.json";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		TaskBook tb = new TaskBook();
		Gson gson = new Gson();
		
		try {
			tb = gson.fromJson(new FileReader(DEFAULT_FILE_NAME), TaskBook.class);
		} catch (FileNotFoundException e) {}

		
		tb.addPerson(create(req,resp));

		// Write the new address book back to disk.
		FileWriter output = new FileWriter(DEFAULT_FILE_NAME);
		output.write(gson.toJson(tb));
		output.close();
		
		resp.sendRedirect("index.html");
	}
	
	private Person create(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		Map<String,String> errors=new HashMap<String,String>();
		String name,idS,email,task,date,ttype,desc;
		int id=0;
		boolean hasTask=true;
		
		name = req.getParameter("name");
		idS = req.getParameter("pid");
		email = req.getParameter("email"); 
		task = req.getParameter("task");
		date = req.getParameter("date");
		ttype = req.getParameter("typetask");
		desc = req.getParameter("description");
		
		/* Comprobacion de que los datos sean correctos*/
		if(name==null || name.equals("")) errors.put("name", "You must write a name");
		if(idS==null || idS.equals("")) errors.put("pid", "You must write an ID");
		else{
			try{
				id=Integer.parseInt(idS);
			}catch(NumberFormatException e){
				errors.put("pid", "You must write a valid ID");
			}
		}
		if(task==null || task.equals(""))hasTask=false;
		if(hasTask && (ttype==null || ttype.equals(""))) errors.put("ttype", "You must write a task type");
		if(hasTask && (desc==null || desc.equals(""))) errors.put("description", "You must write a description");
		if(hasTask && (date!=null && !date.equals("") && !isAValidDate(date))) errors.put("date", 
				"You must write valid date. Format (DDMM)");
		
		if(!errors.isEmpty()){
        	req.setAttribute("errors", errors);
        	RequestDispatcher RD = req.getRequestDispatcher("addPerson.jsp");
        	try {
				RD.forward(req,resp);
			} catch (ServletException | IOException e) {
				resp.sendError(404);
				resp.sendRedirect("error.html");
			}
    		return null;			
        }
		else{
			Person person=new Person();
			Task t=new Task();
			person.setId(id);
			person.setName(name);
			if(email!=null)
			person.setEmail(email);
			if(task!=null){
				t.setTitle(task);
				if(desc!=null)
					t.setDescription(desc);
				if(date!=null)
					t.setDate(date);
				ttype=req.getParameter("typetask");
				
				if (ttype.equals("personal")) {
					t.setType(PERSONAL);
				} else if (ttype.equals("home")) {
					t.setType(HOME);
				} else if (ttype.equals("work")) {
					t.setType(WORK);
				} else {
					t.setType(DEFAULT);
				}
			}
			person.addTask(t);
			return person;
		}
	}
	
	private boolean isAValidDate(String date){
		try{
			int day = Integer.parseInt(date.substring(0, 2));
			int month = Integer.parseInt(date.substring(2,4));
			return !(day<1 || day>31 || month<1 || month>12 || date.length()>4);
			
		}catch(NumberFormatException | StringIndexOutOfBoundsException e){
			return false;
		}
	}
}
