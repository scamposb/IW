package rest.todows;

import java.io.FileWriter;
import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;

@Path("/ToDo")
public class ToDoWebService {

	public final static String DEFAULT_FILE_NAME = "task_book.json";

	/* Shared element */
	@Inject
	ToDoList todoList;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getToDoList() {
		return Response.ok(todoList, MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTask(@Context UriInfo info, ToDoTask task) {
		todoList.addTask(task);
		task.setId(todoList.nextId());
		task.setHref(info.getAbsolutePathBuilder().path("ToDo/{id}").build(task.getId()));
		todoList.addTask(task);
		return Response.created(task.getHref()).entity(task).build();
	}

	@PUT
	@Path("/ToDo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateToDo(@Context UriInfo info,
			@PathParam("id") int id, ToDoTask task) {
		for (int i = 0; i < todoList.getList().size(); i++) {
			if (todoList.getList().get(i).getTitle().equals(title)) {
				task.setHref(info.getAbsolutePath());
				todoList.getList().set(todoList.getList().indexOf(task), task);
				saveData();
				return Response.ok(task).build();
			}
		}
		return Response.status(Status.BAD_REQUEST).build();
	}

	@DELETE
	@Path("/ToDo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeTask(@Context UriInfo info,
			@PathParam("id") int id) {
		boolean result = false;
		result = todoList.removeTask(todoList.getTaskByName(title));
		if(result) return Response.noContent().build();
		else return Response.status(Status.NOT_FOUND).build();
	}

	public void saveData() {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		FileWriter output;
		try {
			output = new FileWriter(filename);
			output.write(gson.toJson(todoList));
			output.close();
		} catch (IOException e) {
			System.out.println("Error en el fichero JSON");
		}
	}
}
