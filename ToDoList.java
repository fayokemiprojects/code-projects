import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public String getStatus() {
        return isCompleted ? "[✔] " : "[ ] ";
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

public class ToDoList {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n📋 TO-DO LIST MENU");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    markTaskAsCompleted();
                    break;
                case 4:
                    removeTask();
                    break;
                case 5:
                    System.out.println("Goodbye! ✅");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\n📝 Your To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i).getStatus() + tasks.get(i).getDescription());
            }
        }
    }

    private static void markTaskAsCompleted() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to mark as completed: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= tasks.size()) {
                tasks.get(index - 1).markAsCompleted();
                System.out.println("Task marked as completed! ✅");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    private static void removeTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to remove: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Task removed successfully! 🗑");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}

 