package servicePackage;
import classPackage.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TodoListService {
	Scanner scannerInput;
	TaskService taskService;
	public TodoListService() {
		this.scannerInput = new Scanner(System.in);
		this.taskService = new TaskService();
	}
	
	// do not save the todo list (for now).
	public void startServiceSequence() {
		System.out.println("Insert the number of task you want to add in the todolist:");
		String outputMsg;
		int numberOfTasks = scannerInput.nextInt();
		scannerInput.nextLine();  
		if (numberOfTasks > 1) {
			outputMsg = "Nice! let's start to configure each of the tasks:";
		} else {
			outputMsg = "Nice! let's start to configure this single task";
		}
		System.out.println(outputMsg);
		// TODO: get or create the todoList
		TodoListClass todoList = new TodoListClass();
		//
		for(int task_n = 1; task_n <= numberOfTasks ; task_n++) {
			TaskClass task = taskService.getSingleTask(task_n);
			todoList.addTaskToList(task);
		}
		// TODO: save to a file
		System.out.println(todoList.toString());
	}
	

}
