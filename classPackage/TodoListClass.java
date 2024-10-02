package classPackage;
import java.util.HashMap;
public class TodoListClass {
	private HashMap<Integer, TaskClass> taskList;
	
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
	
	
}
