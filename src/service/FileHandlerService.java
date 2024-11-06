package service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import entity.TodoListClass;

public class FileHandlerService {

	public TodoListClass getTodoListByFile() {
		TodoListClass todoList = null;
		// Check if the file exists
		File file = new File(TodoListClass.filePath);
		if (file.exists()) {
			// File exists, load the task list
			try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

				// Deserialize the task list
				todoList = (TodoListClass) ois.readObject();
				System.out.println("Task list loaded from file.");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				System.exit(1);
			}
		} else {
			// File does not exist, create it
			try {
				file.createNewFile();
				System.out.println("File does not exist. Creating a new file.");
				todoList = new TodoListClass();

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}

		return todoList;
	}

	public static void saveTodoListToFile(TodoListClass todoList) {
		System.out.println("updating the todo list...");
		// Save the task list to a file
		try (FileOutputStream fileOut = new FileOutputStream(TodoListClass.filePath);
				ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
			out.writeObject(todoList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
