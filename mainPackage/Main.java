package mainPackage;

import java.util.*;
import servicePackage.*;


public class Main {
	public static void main(String[] args) {
		TodoListService service = new TodoListService();
		service.takeAndPrint();
		}
	
}
