package todo;

import java.util.ArrayList;
import java.util.List;

public class Person {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> tasks) {
		this.taskList = tasks;
	}

	public String name;
	public int id;
	public String email;
	public List<Task> taskList = new ArrayList<Task>();
	
	public void addTask(Task t) {
		taskList.add(t);
	}

	public boolean hasEmail() {
		return email != null;
	}
	
}
