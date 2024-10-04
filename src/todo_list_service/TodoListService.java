package todo_list_service;
import java.util.Scanner;

import todo_list_class.*;

import java.io.*;

public class TodoListService {
	Scanner scannerInput;
	TaskService taskService;
	FileHandlerService fileHandlerService;
	public TodoListService() {
		this.scannerInput = new Scanner(System.in);
		this.taskService = new TaskService();
		this.fileHandlerService = new FileHandlerService();
	}
	
	public void startServiceSequence() {
		System.out.println("Insert the number of task you want to add in the todolist:");
		String outputMsg;
		TodoListClass todoList;
		int numberOfTasks = scannerInput.nextInt();
		scannerInput.nextLine();  
		
		if (numberOfTasks > 1) {
			outputMsg = "Nice! let's start to configure each of the tasks:";
		} else {
			outputMsg = "Nice! let's start to configure this single task";
		}
		System.out.println(outputMsg);
        
		todoList = fileHandlerService.getTodoListByFile();
		//
        int previousId = todoList.getMaxId();
		for(int task_n = 1; task_n <= numberOfTasks ; task_n++) {
			TaskClass task = taskService.getSingleTask(task_n + previousId);
			todoList.addTaskToList(task);
		}
	
	    // Save the task list to a file
        try (FileOutputStream fileOut = new FileOutputStream(TodoListClass.filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(todoList);
            System.out.println("Task list serialized to " + TodoListClass.filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		System.out.println(todoList.toString());
		}

}
