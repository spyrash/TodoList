package classPackage;

public class TaskClass {
	private int taskId;
	private String taskStatus;
	private String taskContent;
	private String taskTitle;
	// private String startDate;
	// private String endDate;


	
	public TaskClass(int taskId) {
		this.taskId = taskId;
	}
	
	public int getTaskId() {
		return taskId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getTaskContent() {
		return taskContent;
	}

	public void setTaskContent(String taskContent) {
		this.taskContent = taskContent;
	}

	public String getTaskTitle() {
		return taskTitle;
	}

	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	public String toString() {
		StringBuilder formattedString = new StringBuilder();
		formattedString.append("\n ID: ").append(taskId+"\n");
		formattedString.append("\n TITLE: ").append(taskTitle+"\n");
		formattedString.append("\n CONTENT: ").append(taskContent+"\n");
		formattedString.append("\n STATUS: ").append(taskStatus+"\n");

		return formattedString.toString();
	}
	
	
}
