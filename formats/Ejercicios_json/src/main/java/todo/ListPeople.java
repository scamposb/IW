package todo;

import java.io.FileReader;

import com.google.gson.Gson;


class ListPeople {
	public final static String DEFAULT_FILE_NAME = "task_book.json";

	// Iterates though all people in the AddressBook and prints info about them.
	static void Print(TaskBook tb) {
		for (Person person : tb.getPersonList()) {
			System.out.println("Person ID: " + person.getId());
			System.out.println("  Name: " + person.getName());
			if (person.hasEmail()) {
				System.out.println("  E-mail address: " + person.getEmail());
			}

			for (Task task : person.getTaskList()) {
				switch (task.getType()) {
				case PERSONAL:
					System.out.print("  Personal task #: ");
					break;
				case HOME:
					System.out.print("  Home task #: ");
					break;
				case WORK:
					System.out.print("  Work task #: ");
					break;
				}
				System.out.println(task.getTitle());
			}
		}
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		Gson gson = new Gson();
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing address book.
		TaskBook tb = gson.fromJson(new FileReader(
				filename), TaskBook.class);

		Print(tb);
	}
}