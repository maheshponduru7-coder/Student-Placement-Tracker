public class Main {

    public static void main(String[] args) {

        ProblemManager manager =
                new ProblemManager();

        manager.loadProblems();

        int choice;

        do {

            System.out.println(
                    "\n======================================"
            );

            System.out.println(
                    "      STUDENT PLACEMENT TRACKER"
            );

            System.out.println(
                    "======================================"
            );

            System.out.println("1.  Add Problem");
System.out.println("2.  Display All Problems");
System.out.println("3.  Mark Problem as Solved");
System.out.println("4.  Mark Problem as Unsolved");
System.out.println("5.  Search by Category");
System.out.println("6.  Search by Name");
System.out.println("7.  Update Problem");
System.out.println("8.  Delete Problem");
System.out.println("9.  Show Progress");
System.out.println("10. Filter by Difficulty");
System.out.println("11. Filter by Status");
System.out.println("12. Sort by ID");
System.out.println("13. Sort by Difficulty");
System.out.println("14. Category-wise Progress");
System.out.println("15. Statistics Dashboard");
System.out.println("16. Exit");

            choice =
                    manager.getInteger(
                            "\nEnter your choice: "
                    );

            switch (choice) {

                case 1:
                    manager.addProblem();
                    break;

                case 2:
                    manager.displayProblems();
                    break;

                case 3:
                    manager.markSolved();
                    break;

                case 4:
                    manager.markUnsolved();
                    break;

                case 5:
                    manager.searchCategory();
                    break;

                case 6:
                    manager.searchByName();
                    break;

                case 7:
                    manager.updateProblem();
                    break;

                case 8:
                    manager.deleteProblem();
                    break;

                case 9:
                    manager.showProgress();
                    break;

                case 10:
                    manager.filterByDifficulty();
                    break;

                case 11:
                    manager.filterByStatus();
                    break;

                case 12:
                    manager.sortById();
                    break;

                case 13:
                    manager.sortByDifficulty();
                    break;

                case 14:
                    manager.categoryProgress();
                    break;
                case 15:
    manager.showDashboard();
    break;
                case 16:

                    manager.saveProblems();

                    System.out.println(
                            "\nThank you for using " +
                            "Student Placement Tracker!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice! Please select 1-15."
                    );
            }

        } while (choice != 16);
    }
}


