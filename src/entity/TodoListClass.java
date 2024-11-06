package entity;
import java.io.Serializable;
import java.util.HashMap;
public class TodoListClass implements Serializable {
	private static final long serialVersionUID = 1L;
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
	
	public String titlesToString() {
		StringBuilder formattedString = new StringBuilder();
		taskList.forEach((k, v) -> {
		    formattedString.append("-------------------------------------------------------------------\n").append(v.titleToString());
		});
		return formattedString.toString();
	}
	
	public int getMaxId() {
		int countId = taskList.size();
		return countId;
	}
	
	public TaskClass getTask(int idTask) {
		return taskList.get(idTask);
	}
}
