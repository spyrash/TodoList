package todo_list_class;
import java.util.HashMap;
public class TodoListClass {
	private HashMap<Integer, TaskClass> taskList;
	public static final String filePath = "TODO.txt";
	
	public TodoListClass() {
		this.taskList = new HashMap<Integer, TaskClass>();
	}
	
	public HashMap<Integer, TaskClass> getTaskList() {
		return taskList;
	}
	
	public void addTaskToList(TaskClass task) {
		taskList.put(task.getTaskId(), task);
	}
	
	public void removeSingleTask(int taskId) {
		taskList.remove(taskId);
	}
	
	public String toString() {
		StringBuilder formattedString = new StringBuilder();
		taskList.forEach((k, v) -> {
		    formattedString.append("-------------------------------------------------------------------\n").append(v.toString());
		});
		return formattedString.toString();
	}
}
