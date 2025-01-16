import java.util.ArrayList;
import java.util.Scanner;

class Workout {
    private String type;
    private int duration;
    private int caloriesBurned;

    public Workout(String type, int duration, int caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
    }

    public String getDetails() {
        return String.format("%s - %d min | %d calories", type, duration, caloriesBurned);
    }
}

public class FitnessApp {
    private static ArrayList<Workout> workouts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nFITNESS TRACKER MENU");
            System.out.println("1. Log a Workout");
            System.out.println("2. View Workout History");
            System.out.println("3. Remove a Workout Entry");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    logWorkout();
                    break;
                case 2:
                    viewWorkoutHistory();
                    break;
                case 3:
                    removeWorkout();
                    break;
                case 4:
                    System.out.println("Stay fit! Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void logWorkout() {
        System.out.print("Enter workout type: ");
        String type = scanner.nextLine();
        System.out.print("Enter duration in minutes: ");
        int duration = scanner.nextInt();
        System.out.print("Enter estimated calories burned: ");
        int caloriesBurned = scanner.nextInt();
        scanner.nextLine();

        workouts.add(new Workout(type, duration, caloriesBurned));
        System.out.println("Workout logged successfully!");
    }

    private static void viewWorkoutHistory() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts recorded yet.");
        } else {
            System.out.println("\nWorkout History:");
            for (int i = 0; i < workouts.size(); i++) {
                System.out.println((i + 1) + ". " + workouts.get(i).getDetails());
            }
        }
    }

    private static void removeWorkout() {
        viewWorkoutHistory();
        if (!workouts.isEmpty()) {
            System.out.print("Enter workout number to remove: ");
            int index = scanner.nextInt();
            if (index > 0 && index <= workouts.size()) {
                workouts.remove(index - 1);
                System.out.println("Workout removed successfully.");
            } else {
                System.out.println("Invalid workout number.");
            }
        }
    }
}
