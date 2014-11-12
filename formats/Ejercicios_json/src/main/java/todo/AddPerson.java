package todo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import com.google.gson.Gson;

import static todo.TaskType.*;

public class AddPerson {
	
	public final static String DEFAULT_FILE_NAME = "task_book.json";

	// This function fills in a Person message based on user input.
	static Person PromptForAddress(BufferedReader stdin, PrintStream stdout)
			throws IOException {
		Person person = new Person();

		stdout.print("Enter person ID: ");
		person.setId(Integer.valueOf(stdin.readLine()));

		stdout.print("Enter name: ");
		person.setName(stdin.readLine());

		stdout.print("Enter email address (blank for none): ");
		String email = stdin.readLine();
		if (email.length() > 0) {
			person.setEmail(email);
		}

		while (true) {
			stdout.print("Enter a task (or leave blank to finish): ");
			String title = stdin.readLine();
			if (title.length() == 0) {
				break;
			}

			Task oneTask = new Task();
			oneTask.setTitle(title);

			stdout.print("Is this a personal, home, or work task? ");
			String type = stdin.readLine();
			if (type.equals("personal")) {
				oneTask.setType(PERSONAL);
			} else if (type.equals("home")) {
				oneTask.setType(HOME);
			} else if (type.equals("work")) {
				oneTask.setType(WORK);
			} else {
				stdout.println("Unknown task type.  Using default.");
			}
			
			stdout.print("Has the task a finish date? (leave blank if it isnt): ");
			String date=stdin.readLine();
			if(date.length()!=0){
				oneTask.setDate(date);
			}
			
			stdout.print("Insert a little description of the task: ");
			String description=stdin.readLine();
			if(date.length()!=0){
				oneTask.setDescription(description);
			}
			
			person.addTask(oneTask);
		}

		return person;
	}

	// Main function: Reads the entire address book from a file,
	// adds one person based on user input, then writes it back out to the same
	// file.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename=args[0];
		}

		TaskBook tb = new TaskBook();
		Gson gson = new Gson();

		// Read the existing address book.
		try {
			tb = gson.fromJson(new FileReader(filename), TaskBook.class);
		} catch (FileNotFoundException e) {
			System.out.println(filename
					+ ": File not found.  Creating a new file.");
		}

		// Add an address.
		tb.addPerson(PromptForAddress(new BufferedReader(
				new InputStreamReader(System.in)), System.out));

		// Write the new address book back to disk.
		FileWriter output = new FileWriter(filename);
		output.write(gson.toJson(tb));
		output.close();
	}
}
