package bigws.todows.connections;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import bigws.todows.elements.ToDoList;
import bigws.todows.elements.ToDoTask;

import com.google.gson.Gson;

@WebService
public class ToDoWebService {

	public final static String DEFAULT_FILE_NAME = "todo_list.json";

	@WebMethod()
	public String addTask(String title, int priority, String date,
			String description) {
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
	public String removeTask(String title) {
		String filename = DEFAULT_FILE_NAME;
		String result = "";
		ToDoList list = new ToDoList();
		Gson gson = new Gson();

		try {
			list = gson.fromJson(new FileReader(filename), ToDoList.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found. Creating a new file.");
		}
		ToDoTask task = list.getTaskByName(title);
		if (list.removeTask(task)) {
			/* Remove task to the list */
			result = "Task removed from the list";
		} else {
			result = "The task doesn�t exist";
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