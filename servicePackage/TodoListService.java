package servicePackage;
import java.util.Scanner;

public class TodoListService {
	Scanner scannerInput;
	
	public TodoListService() {
		this.scannerInput = new Scanner(System.in);
	}
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
		for(int task_n = 1; task_n < numberOfTasks ; task_n++) {
			addSingleTask();
		}
	}
	
	private void addSingleTask() {
		
	}
	
	public void takeAndPrint() {
	    System.out.println("add task number:");
	    int taskNumber = scannerInput.nextInt();  // Read user input
	    System.out.println("task number is: "+ taskNumber);  // Output user input
	    scannerInput.close();
	}
}
