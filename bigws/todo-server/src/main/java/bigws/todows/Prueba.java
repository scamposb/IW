package bigws.todows;

import java.util.Vector;

public class Prueba {
	private Vector<ToDoTask> todoList;
	
	public Prueba(){
		todoList = new Vector<ToDoTask>();
	}
	
	public Vector<ToDoTask> getToDoList(){
		return this.todoList;
	}
	
	public void setToDoList(Vector<ToDoTask> nTodo){
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
	public Vector<ToDoTask> getList(){
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
	
	public static void main (String [] args){
		Prueba p = new Prueba();
		ToDoTask t = new ToDoTask("prueba1",2,"4554","sdsd");
		ToDoTask t2 = new ToDoTask("prueba2",3,"4552","sdss");
		p.addTask(t);
		p.addTask(t2);
		System.out.println(p.toString());
		p.removeTask(t2);
		//System.out.println(p.getList().indexOf(t));
		//System.out.println(p.getList().remove(t));
	}
}
