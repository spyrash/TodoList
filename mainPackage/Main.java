package mainPackage;

import servicePackage.*;


public class Main {
	public static void main(String[] args) {
		TodoListService service = new TodoListService();
		service.startServiceSequence();
		}
	
}
