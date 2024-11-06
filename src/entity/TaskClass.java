package entity;

import java.io.Serializable;

import enums.TaskStatusEnum;

public class TaskClass implements Serializable {

	private static final long serialVersionUID = 1L;
	private int taskId;
	private TaskStatusEnum taskStatus;
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

	public TaskStatusEnum getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatusEnum taskEnumValue) {
		this.taskStatus = taskEnumValue;
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
		formattedString.append("\n ID: ").append(taskId + "\n");
		formattedString.append("\n TITLE: ").append(taskTitle + "\n");
		formattedString.append("\n CONTENT: ").append(taskContent + "\n");
		formattedString.append("\n STATUS: ").append(taskStatus + "\n");

		return formattedString.toString();
	}

	public String titleToString() {
		StringBuilder formattedString = new StringBuilder();
		formattedString.append("\n ID: ").append(taskId + ", ");
		formattedString.append("\n TITLE: ").append(taskTitle + "\n");

		return formattedString.toString();
	}

}
