package todo_list_service;

import todo_list_enum.TaskStatusEnum;

import java.util.*;

import todo_list_class.TaskClass;

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
	
	public void editTitle (TaskClass task) {
		System.out.println("Current title: " + task.getTaskTitle());
		System.out.println("New title: ");
		String newTitle = scannerInput.nextLine();
		task.setTaskTitle(newTitle);
		System.out.println("Title changed!");
	}
	
	public void editContent (TaskClass task) {
		System.out.println("Current content: " + task.getTaskContent());
		System.out.println("New content: ");
		String newContent = scannerInput.nextLine();
		task.setTaskContent(newContent);
		System.out.println("Content changed!");
	}
	
	public void editStatus (TaskClass task) {
		TaskStatusEnum status = null;
		System.out.println("Current status: " + task.getTaskStatus());
		System.out.println("Choose new status");
		System.out.println("1) " + TaskStatusEnum.BACKLOG + "(a)");
		System.out.println("2) " + TaskStatusEnum.DOING + "(b)");
		System.out.println("3) " + TaskStatusEnum.TEST + "(c)");
		System.out.println("4) " + TaskStatusEnum.DONE+ "(d)");
		String input = scannerInput.nextLine();
		char choice = input.charAt(0);
		switch (choice) {
		case 'a':
			status = TaskStatusEnum.BACKLOG;
			break;
		case 'b':
			status = TaskStatusEnum.DOING;
			break;
		case 'c':
			status = TaskStatusEnum.TEST;
			break;
		case 'd':
			status = TaskStatusEnum.DONE;
			break;
		}
		task.setTaskStatus(status);
		System.out.println("Status changed!");
	}
}
