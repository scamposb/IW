package rest.todows;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.Grizzly;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;

public class Server {
	private static final Logger LOGGER = Grizzly.logger(Server.class);
	public final static String DEFAULT_FILE_NAME = "task_book.json";

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		LOGGER.setLevel(Level.FINER);
//		String filename = DEFAULT_FILE_NAME;
		ToDoList list = new ToDoList();
//		Gson gson = new Gson();
//		try {
//			list = gson.fromJson(new FileReader(filename), ToDoList.class);
//		} catch (FileNotFoundException e) {
//			System.out.println(filename
//					+ ": File not found. Creating a new file.");
//		}

		URI uri = UriBuilder.fromUri("http://localhost/").port(8081).build();
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri,
				new ApplicationConfig(list));
		try {
			server.start();
			LOGGER.info("Press 's' to shutdown now the server...");
			while (true) {
				int c = System.in.read();
				if (c == 's')
					break;
			}
		} catch (IOException ioe) {
			LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
		} finally {
			server.stop();
			LOGGER.info("Server stopped");
		}
	}
}
