package bigws.todows;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.google.gson.Gson;

@WebService
public class ToDoWebService {

	public final static String DEFAULT_FILE_NAME = "task_book.json";

	@WebMethod()
	public String addTask(
			@WebParam (name="title")String title,@WebParam (name="priority") int priority,@WebParam (name="date") String date,
			@WebParam (name="description")String description) {
		String filename = DEFAULT_FILE_NAME;
		String result = "";
		ToDoList list = new ToDoList();
		Gson gson = new Gson();

		ToDoTask task = new ToDoTask(title, priority, date, description);
		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}

		list.addTask(task); /* Add task to the list */

		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(list));
			output.close();
			result = "Task added";
		} catch (IOException e) {
			result = e.getMessage();
		}
		return result;
	}

	@WebMethod()
	public String removeTask(@WebParam (name="title") String title) {
		String filename = DEFAULT_FILE_NAME;
		String result = "Result: ";
		ToDoList list = new ToDoList();
		Gson gson = new Gson();

		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}
		ToDoTask task = list.getTaskByName(title);
		System.out.println("---->EL SERVER COGE LA TAREA ASI: "+task.toString());
		boolean success = list.removeTask(task);
		System.out.println("RESULTADO BORRAR "+success);
		if (success) {
			/* Remove task to the list */
			result = "Task removed from the list";
		} else {
			result = "The task doesn´t exist";
		}

		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(list));
			output.close();
		} catch (IOException e) {
			result += e.getMessage();
		}

		return result;

	}

	@WebMethod()
	public String listTasks() {
		String filename = DEFAULT_FILE_NAME;
		ToDoList list = new ToDoList();
		Gson gson = new Gson();
		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}
		return list.toString();
	}

}
