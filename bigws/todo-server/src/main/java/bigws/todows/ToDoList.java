package bigws.todows;

import java.util.LinkedList;

public class ToDoList {

private LinkedList<ToDoTask> todoList;
	
	public ToDoList(){
		todoList = new LinkedList<ToDoTask>();
	}
	
	public LinkedList<ToDoTask> getToDoList(){
		return this.todoList;
	}
	
	public void setToDoList(LinkedList<ToDoTask> nTodo){
		this.todoList = nTodo;
	}
	
	public boolean addTask(ToDoTask task){
		return this.todoList.add(task);
	}
	
	public boolean removeTask(ToDoTask task){
		System.out.println("---->LISTAMOS EL LIBRO "+this.todoList.toString());
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
	public LinkedList<ToDoTask> getList(){
		return this.todoList;
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
