package servicePackage;
import java.util.Scanner;
public class TodoListService {
	public void takeAndPrint() {
		Scanner scannerInput = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("add task number:");
	    int taskNumber = scannerInput.nextInt();  // Read user input
	    System.out.println("task number is: "+ taskNumber);  // Output user input
	    scannerInput.close();
	}
}
