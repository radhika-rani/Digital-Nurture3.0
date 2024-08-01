package com.taskmanagement;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Add Tasks
        manager.addTask(new Task(1, "Task 1", "Pending"));
        manager.addTask(new Task(2, "Task 2", "In Progress"));
        manager.addTask(new Task(3, "Task 3", "Completed"));

        // Traverse Tasks
        System.out.println("All Tasks:");
        manager.traverseTasks();

        // Search for a Task
        System.out.println("\nSearching for Task ID 2:");
        Task task = manager.searchTask(2);
        System.out.println(task != null ? task : "Task not found.");

        // Delete a Task
        System.out.println("\nDeleting Task ID 2:");
        manager.deleteTask(2);
        System.out.println("Tasks after deletion:");
        manager.traverseTasks();
    }
}
