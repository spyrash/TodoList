package todo_list_main;

import todo_list_service.*;


public class Main {
	public static void main(String[] args) {
		TodoListService service = new TodoListService();
		service.startServiceSequence();
		}
	
}
