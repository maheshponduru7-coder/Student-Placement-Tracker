import java.util.ArrayList;
import java.util.Scanner;

class Problem {
    int id;
    String name;
    String category;
    String difficulty;
    boolean solved;

    Problem(int id, String name, String category, String difficulty) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.solved = false;
    }

    void display() {
        System.out.println(
            id + " | " + name + " | " +
            category + " | " + difficulty + " | " +
            (solved ? "Solved" : "Not Solved")
        );
    }
}

public class Main {

    static ArrayList<Problem> problems = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void addProblem() {

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Problem Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Difficulty (Easy/Medium/Hard): ");
        String difficulty = scanner.nextLine();

        problems.add(new Problem(id, name, category, difficulty));

        System.out.println("Problem added successfully!");
    }

    public static void displayProblems() {

        if (problems.isEmpty()) {
            System.out.println("No problems available.");
            return;
        }

        System.out.println("\n===== DSA PROBLEMS =====");

        for (Problem problem : problems) {
            problem.display();
        }
    }

    public static void markSolved() {

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();

        for (Problem problem : problems) {

            if (problem.id == id) {
                problem.solved = true;
                System.out.println("Problem marked as solved!");
                return;
            }
        }

        System.out.println("Problem not found.");
    }

    public static void searchCategory() {

        scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        boolean found = false;

        for (Problem problem : problems) {

            if (problem.category.equalsIgnoreCase(category)) {
                problem.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No problems found.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== STUDENT PLACEMENT TRACKER =====");
            System.out.println("1. Add Problem");
            System.out.println("2. Display Problems");
            System.out.println("3. Mark Problem as Solved");
            System.out.println("4. Search by Category");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    addProblem();
                    break;

                case 2:
                    displayProblems();
                    break;

                case 3:
                    markSolved();
                    break;

                case 4:
                    searchCategory();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        scanner.close();
    }
}