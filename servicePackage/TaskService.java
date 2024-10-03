package servicePackage;

import classPackage.TaskClass;
import java.util.*;

public class TaskService {
	
	Scanner scannerInput;
	
	public TaskService() {
		this.scannerInput = new Scanner(System.in);
	}
	
	public TaskClass getSingleTask(int task_n) {
		return createSingleTask(task_n);
	}
	
	private TaskClass createSingleTask(int task_n) {
		TaskClass task = new TaskClass(task_n);
		System.out.println(task_n + ") Insert the title of the task:");
		String titleTask = scannerInput.nextLine();
		task.setTaskTitle(titleTask);
		System.out.println(task_n + ") Insert the content of the task:");
		String contentTask = scannerInput.nextLine();
		task.setTaskContent(contentTask);

		// System.out.println("Insert the number of task you want to add in the todolist:");
		// TODO: get input status or just set this as backlog, then do service to change status single task.(2nd is better)
		// System.out.println("Insert the number of task you want to add in the todolist:");
		
		return task;
	}
}
