package servicePackage;

import classPackage.TaskClass;
import enumPackage.TaskStatusEnum;

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
		// just set this as backlog, then do service to change status single task.

		task.setTaskStatus(TaskStatusEnum.BACKLOG);
		
		// TODO: support start date and end date
		
		return task;
	}
}
