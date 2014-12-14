package rest.todows;

import java.net.URI;

public class ToDoTask {

	private String title;
	private int priority;
	private String date;
	private String description;
	/* Extra for REST */
	private URI href;
	private int id;

	public ToDoTask(String title, int priority, String date, String description) {
		this.title = title;
		this.priority = priority;
		this.date = date;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public URI getHref() {
		return href;
	}

	public void setHref(URI href) {
		this.href = href;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ToDoTask [title=" + title + ", priority=" + priority
				+ ", date=" + date + ", description=" + description + "]";
	}

}
