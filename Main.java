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
                id + " | " +
                name + " | " +
                category + " | " +
                difficulty + " | " +
                (solved ? "Solved" : "Not Solved")
        );
    }
}

public class Main {

    static ArrayList<Problem> problems = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    // ================= ADD PROBLEM =================

    public static void addProblem() {

        System.out.println("\n===== ADD PROBLEM =====");

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        // Check duplicate ID
        for (Problem problem : problems) {
            if (problem.id == id) {
                System.out.println("Problem ID already exists!");
                return;
            }
        }

        System.out.print("Enter Problem Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Difficulty (Easy/Medium/Hard): ");
        String difficulty = scanner.nextLine();

        problems.add(new Problem(id, name, category, difficulty));

        System.out.println("Problem added successfully!");
    }

    // ================= DISPLAY PROBLEMS =================

    public static void displayProblems() {

        System.out.println("\n===== ALL PROBLEMS =====");

        if (problems.isEmpty()) {
            System.out.println("No problems available.");
            return;
        }

        System.out.println(
                "ID | Name | Category | Difficulty | Status"
        );

        System.out.println(
                "-------------------------------------------------------"
        );

        for (Problem problem : problems) {
            problem.display();
        }
    }

    // ================= MARK SOLVED =================

    public static void markSolved() {

        System.out.println("\n===== MARK PROBLEM SOLVED =====");

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();

        for (Problem problem : problems) {

            if (problem.id == id) {

                if (problem.solved) {
                    System.out.println("Problem is already solved.");
                } else {
                    problem.solved = true;
                    System.out.println("Problem marked as solved!");
                }

                return;
            }
        }

        System.out.println("Problem not found.");
    }

    // ================= MARK UNSOLVED =================

    public static void markUnsolved() {

        System.out.println("\n===== MARK PROBLEM UNSOLVED =====");

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();

        for (Problem problem : problems) {

            if (problem.id == id) {

                problem.solved = false;

                System.out.println("Problem marked as unsolved!");

                return;
            }
        }

        System.out.println("Problem not found.");
    }

    // ================= SEARCH BY CATEGORY =================

    public static void searchCategory() {

        scanner.nextLine();

        System.out.println("\n===== SEARCH BY CATEGORY =====");

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
            System.out.println("No problems found in this category.");
        }
    }

    // ================= SEARCH BY NAME =================

    public static void searchByName() {

        scanner.nextLine();

        System.out.println("\n===== SEARCH BY NAME =====");

        System.out.print("Enter Problem Name: ");
        String name = scanner.nextLine();

        boolean found = false;

        for (Problem problem : problems) {

            if (problem.name.toLowerCase()
                    .contains(name.toLowerCase())) {

                problem.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching problems found.");
        }
    }

    // ================= UPDATE PROBLEM =================

    public static void updateProblem() {

        System.out.println("\n===== UPDATE PROBLEM =====");

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Problem problem : problems) {

            if (problem.id == id) {

                System.out.print("Enter New Problem Name: ");
                problem.name = scanner.nextLine();

                System.out.print("Enter New Category: ");
                problem.category = scanner.nextLine();

                System.out.print("Enter New Difficulty: ");
                problem.difficulty = scanner.nextLine();

                System.out.println("Problem updated successfully!");

                return;
            }
        }

        System.out.println("Problem not found.");
    }

    // ================= DELETE PROBLEM =================

    public static void deleteProblem() {

        System.out.println("\n===== DELETE PROBLEM =====");

        System.out.print("Enter Problem ID: ");
        int id = scanner.nextInt();

        for (int i = 0; i < problems.size(); i++) {

            if (problems.get(i).id == id) {

                problems.remove(i);

                System.out.println("Problem deleted successfully!");

                return;
            }
        }

        System.out.println("Problem not found.");
    }

    // ================= PROGRESS =================

    public static void showProgress() {

        System.out.println("\n===== PROGRESS =====");

        if (problems.isEmpty()) {
            System.out.println("No problems available.");
            return;
        }

        int solved = 0;

        for (Problem problem : problems) {

            if (problem.solved) {
                solved++;
            }
        }

        int total = problems.size();

        double percentage = ((double) solved / total) * 100;

        System.out.println("Total Problems : " + total);
        System.out.println("Solved         : " + solved);
        System.out.println("Unsolved       : " + (total - solved));

        System.out.printf("Progress       : %.2f%%\n", percentage);
    }

    // ================= MAIN MENU =================

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("   STUDENT PLACEMENT TRACKER");
            System.out.println("======================================");

            System.out.println("1.  Add Problem");
            System.out.println("2.  Display All Problems");
            System.out.println("3.  Mark Problem as Solved");
            System.out.println("4.  Mark Problem as Unsolved");
            System.out.println("5.  Search by Category");
            System.out.println("6.  Search by Name");
            System.out.println("7.  Update Problem");
            System.out.println("8.  Delete Problem");
            System.out.println("9.  Show Progress");
            System.out.println("10. Exit");

            System.out.print("\nEnter your choice: ");

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
                    markUnsolved();
                    break;

                case 5:
                    searchCategory();
                    break;

                case 6:
                    searchByName();
                    break;

                case 7:
                    updateProblem();
                    break;

                case 8:
                    deleteProblem();
                    break;

                case 9:
                    showProgress();
                    break;

                case 10:
                    System.out.println(
                            "\nThank you for using Student Placement Tracker!"
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice! Please try again."
                    );
            }

        } while (choice != 10);

        scanner.close();
    }
}