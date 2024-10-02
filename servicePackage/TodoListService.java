package servicePackage;
import classPackage.*;
import java.util.Scanner;

public class TodoListService {
	Scanner scannerInput;
	
	public TodoListService() {
		this.scannerInput = new Scanner(System.in);
	}
	
	// do not save the todo list (for now).
	public void startServiceSequence() {
		System.out.println("Insert the number of task you want to add in the todolist:");
		String outputMsg;
		int numberOfTasks = scannerInput.nextInt();
		if (numberOfTasks > 1) {
			outputMsg = "Nice! let's start to configure each of the tasks:";
		} else {
			outputMsg = "Nice! let's start to configure this single task";
		}
		System.out.println(outputMsg);
		// TODO: get or create the todoList
		TodoListClass todoList = new TodoListClass();
		//
		for(int task_n = 1; task_n < numberOfTasks ; task_n++) {
			createSingleTask();
		}
	}
	
	private void createSingleTask() {
		
	}
	
	public void takeAndPrint() {
	    System.out.println("add task number:");
	    int taskNumber = scannerInput.nextInt();  // Read user input
	    System.out.println("task number is: "+ taskNumber);  // Output user input
	    scannerInput.close();
	}
}
