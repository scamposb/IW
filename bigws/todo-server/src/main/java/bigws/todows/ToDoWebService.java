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
	public boolean addTask(
			@WebParam (name="title")String title,@WebParam (name="priority") int priority,@WebParam (name="date") String date,
			@WebParam (name="description")String description) {
		String filename = DEFAULT_FILE_NAME;
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
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	@WebMethod()
	public boolean removeTask(@WebParam (name="title") String title) {
		String filename = DEFAULT_FILE_NAME;
		ToDoList list = new ToDoList();
		Gson gson = new Gson();

		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}
		ToDoTask task = list.getTaskByName(title);
		boolean success = list.removeTask(task);

		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(list));
			output.close();
		} catch (IOException e) {
			success = false;
		}

		return success;

	}

	@WebMethod()
	public ToDoList listTasks() {
		String filename = DEFAULT_FILE_NAME;
		ToDoList list = new ToDoList();
		Gson gson = new Gson();
		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}
		return list;
	}

}
