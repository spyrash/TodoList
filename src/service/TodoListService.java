package service;

import java.util.Scanner;

import entity.TaskClass;
import entity.TodoListClass;

public class TodoListService {
	Scanner scannerInput;
	TaskService taskService;
	FileHandlerService fileHandlerService;

	final char addTask = 'a';
	final char editTask = 'b';
	final char printTodo = 'c';
	final char removeTask = 'd';
	final char printTitlesTask = 'e';
	final char exit = 'z';

	final char editTitle = 'f';
	final char editContent = 'g';
	final char editStatus = 'h';

	public TodoListService() {
		this.scannerInput = new Scanner(System.in);
		this.taskService = new TaskService();
		this.fileHandlerService = new FileHandlerService();
	}

	public void startServiceSequence() {
		dispatcherOfChoice();
	}

	public void dispatcherOfChoice() {
		boolean continueDispatcher = true;
		TodoListClass todoList;
		todoList = fileHandlerService.getTodoListByFile();
		//
		System.out.println("Hi! what would you like to do?");
		while (continueDispatcher) {
			System.out.println("1) Add one or multiple task to the list (a)");
			System.out.println("2) Edit a specific task (b)");
			System.out.println("3) Print the Todo list (c)");
			System.out.println("4) Remove a single task (d)");
			System.out.println("5) Print the titles of all the task in the Todo list (e)");
			System.out.println("6) Exit (z)");
			String input = scannerInput.nextLine();
			char choice = input.charAt(0);

			switch (choice) {
			case addTask:
				todoList = addTask(todoList);
				break;
			case editTask:
				todoList = editTask(todoList);
				break;
			case printTodo:
				System.out.println(todoList.toString());
				break;
			case removeTask:
				removeTask(todoList);
				break;
			case printTitlesTask:
				System.out.println(todoList.titlesToString());
				break;
			case exit:
				continueDispatcher = false;
				break;
			}
			if (continueDispatcher) {
				System.out.println("Would you like to do something else?");
			}
		}
		System.out.println("Bye!");
	}

	public TodoListClass addTask(TodoListClass todoList) {
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

		int previousId = todoList.getMaxId();
		for (int task_n = 1; task_n <= numberOfTasks; task_n++) {
			TaskClass task = taskService.getSingleTask(task_n + previousId);
			todoList.addTaskToList(task);
		}

		// Save the task list to a file
		FileHandlerService.saveTodoListToFile(todoList);

		return todoList;
	}

	public TodoListClass editTask(TodoListClass todoList) {

		TaskClass task = null;
		boolean continueEdit = true;
		if (todoList.getTaskList().isEmpty()) {
			System.out.println("The Todo list is empty! sorry!");
			return todoList;
		}
		System.out.println("Please inserte the ID of the task to edit:");
		try {
			int taskId = scannerInput.nextInt();
			task = todoList.getTask(taskId);
			scannerInput.nextLine();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			System.exit(1);
		}
		System.out.println("Task obtained:" + task.toString());

		while (continueEdit) {
			System.out.println("What you want to change about this task?");
			System.out.println("1) The title (f)");
			System.out.println("2) The content (g)");
			System.out.println("3) The status (h)");
			System.out.println("4) exit (z)");
			String input = scannerInput.nextLine();
			char choice = input.charAt(0);
			switch (choice) {
			case editTitle:
				taskService.editTitle(task);
				break;
			case editContent:
				taskService.editContent(task);
				break;
			case editStatus:
				taskService.editStatus(task);
				break;
			case exit:
				continueEdit = false;
			}
		}
		// Save the task list to a file
		FileHandlerService.saveTodoListToFile(todoList);
		return todoList;
	}

	public TodoListClass removeTask(TodoListClass todoList) {
		TaskClass task = null;
		int taskId = 0;

		if (todoList.getTaskList().isEmpty()) {
			System.out.println("The Todo list is empty! sorry!");
			return todoList;
		}
		System.out.println("Please inserte the ID of the task to remove:");
		try {
			taskId = scannerInput.nextInt();
			task = todoList.getTask(taskId);
			scannerInput.nextLine();
		} catch (Exception e) {
			System.out.println("Something went wrong!");
			System.exit(1);
		}
		if (0 == taskId) {
			System.exit(1);
		}
		if (null == task) {
			System.out.println("Task not found!");
			return todoList;
		}
		todoList.removeSingleTask(taskId);
		System.out.println("Task removed");
		FileHandlerService.saveTodoListToFile(todoList);
		return todoList;
	}

}
