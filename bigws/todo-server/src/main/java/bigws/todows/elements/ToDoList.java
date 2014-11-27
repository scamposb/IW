package bigws.todows.elements;

import java.util.ArrayList;

public class ToDoList {

	private ArrayList<ToDoTask> todoList;
	
	public ToDoList(){
		todoList = new ArrayList<ToDoTask>();
	}
	
	public ArrayList<ToDoTask> getToDoList(){
		return this.todoList;
	}
	
	public void setToDoList(ArrayList<ToDoTask> nTodo){
		this.todoList = nTodo;
	}
	
	public boolean addTask(ToDoTask task){
		return this.todoList.add(task);
	}
	
	public boolean removeTask(ToDoTask task){
		return this.todoList.remove(task);
	}
	
	public ToDoTask getTaskByName(String name){
		for(ToDoTask t : todoList){
			if(t.getTitle().equalsIgnoreCase(name)){
				return new ToDoTask(t.getTitle(),t.getPriority(),t.getDate(),t.getDescription());
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String result = "";
		for(ToDoTask t : todoList){
			result += "Title: "+t.getTitle() +"\n"
					+ "Priority: "+t.getPriority()+"\n"
					+ "Date: "+t.getDate()+"\n"
					+ "Description: "+t.getDescription()+"\n\n";
		}
		if(todoList.size()<0) result="Empty list";
		return result;
	}
	
	
}