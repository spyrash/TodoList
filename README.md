# Todo List Service

This Java project provides a command-line application to manage a to-do list, allowing users to create, edit, view, and remove tasks. The application stores the to-do list in a file, so the data persists across sessions.

## Features

- Add one or multiple tasks to the to-do list.
- Edit a task's title, content, or status.
- Display the entire to-do list or just the task titles.
- Remove tasks from the list.
- Persistent storage of tasks using file I/O.

## Project Structure

The project consists of the following core classes:

### 1. `TodoListService`
   This is the main service class that drives the application's functionality. It handles user inputs and interacts with other services to manage tasks.

### 2. `TaskService`
   Provides methods for creating and editing individual tasks.

### 3. `FileHandlerService`
   Manages loading and saving the to-do list to/from a file. Ensures that the task list is persistent across application sessions.

### 4. `TodoListClass` *(Not shown in the code above)*
   A class that represents the to-do list itself, storing tasks and offering methods to manage them.

### 5. `TaskClass` *(Not shown in the code above)*
   Represents an individual task, containing attributes like title, content, and status.

### 6. `TaskStatusEnum`
   Enum that defines the different statuses a task can have: `BACKLOG`, `DOING`, `TEST`, and `DONE`.

## How to Run

1. Clone the repository.
2. Compile the Java code using a Java compiler (e.g., `javac`).
3. Run the `Main` class to start the application.

```bash
javac -d bin src/todo_list_main/Main.java
java -cp bin todo_list_main.Main

```
4) Follow the on-screen instructions to manage your to-do list.
## User Instructions
Once the application is running, you will be presented with the following options:

1) Add Task (a) – Add one or more tasks to the to-do list.
2) Edit Task (b) – Edit an existing task's title, content, or status.
3) Print Todo List (c) – Display the entire to-do list.
4) Remove Task (d) – Remove a task by its ID.
5) Print Task Titles (e) – Display only the titles of all tasks.
6) Exit (z) – Exit the application.
## Dependencies
No external dependencies are required for this project. It uses standard Java libraries such as:
- java.util.* for collections and user input.
- java.io.* for file handling and serialization.

## Future Improvements
- Add support for start and end dates for tasks.
- Implement more complex search and filtering options for tasks.
- Improve the user interface.
