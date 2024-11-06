package main;

import service.TodoListService;

public class Main {
	public static void main(String[] args) {
		TodoListService service = new TodoListService();
		service.startServiceSequence();
	}

}
