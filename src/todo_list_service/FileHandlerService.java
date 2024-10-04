package todo_list_service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import todo_list_class.TodoListClass;

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
}
