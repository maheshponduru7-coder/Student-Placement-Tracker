public class Main {

    public static void main(String[] args) {

        ProblemManager manager =
                new ProblemManager();

        manager.loadProblems();

         DatabaseManager database = new DatabaseManager();

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
System.out.println("16. Search by company");
System.out.println("17. Search by Topic");
System.out.println("18. Advanced Search");
System.out.println("19. Search by ID");
System.out.println("20. Search unique companies and topics");
System.out.println("21.Advanced Statistics");
System.out.println("22.Display problems from SQL");
System.out.println("23.Add problem to mySQL");
System.out.println("24.Update problem in MySQL");
System.out.println("25.Delete problem from MySQL");
System.out.println("26.Mark Problem solved in MySQL");
System.out.println("27.Mark problem unsolved in MySQL");
System.out.println("28.Search MySQL by Company");
System.out.println("29.Search MySQL by Topic");
System.out.println("30.Search MySQL by Difficulty");
System.out.println("31.Search MySQL by Status");
System.out.println("32.Exit");

             choice = manager.getMenuChoice();

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
    manager.searchByCompany();
    break;

case 17:
    manager.searchByTopic();
    break;
case 18:
    manager.advancedSearch();
    break;
case 19:
    manager.searchByIdUsingHashMap();
    break;

case 20:
    manager.showUniqueCompaniesAndTopics();
    break;
case 21:
    manager.advancedStatistics();
    break;
case 22:
    database.displayAllProblems();
    break;
case 23:
    System.out.println("\n===== ADD PROBLEM TO MYSQL =====");

    int id = manager.getInteger("Enter Problem ID: ");

   
    String name = manager.getNonEmptyInput("Enter Problem Name: ");

   
    
    String category = manager.getNonEmptyInput("Enter Category: ");

    String difficulty = manager.getDifficulty();

   
    String company = manager.getNonEmptyInput("Enter Company: ");

   
    String topic = manager.getNonEmptyInput("Enter Topic: ");

    Problem problem = new Problem(
            id, name, category, difficulty, company, topic
    );

    database.addProblem(problem);
    break;
case 24:
    System.out.println("\n===== UPDATE PROBLEM IN MYSQL =====");

    int updateId = manager.getInteger("Enter Problem ID: ");

    
    String updateName = manager.getNonEmptyInput("Enter Problem Name: ");

   
    String updateCategory = manager.getNonEmptyInput("Enter Category: ");

    String updateDifficulty = manager.getDifficulty();

    
    String updateCompany = manager.getNonEmptyInput("Enter Company: ");

  
    String updateTopic = manager.getNonEmptyInput("Enter Topic: ");

    Problem updatedProblem = new Problem(
            updateId,
            updateName,
            updateCategory,
            updateDifficulty,
            updateCompany,
            updateTopic
    );

    System.out.print("Is the problem solved? (true/false): ");
    updatedProblem.solved = Boolean.parseBoolean(
            manager.getNonEmptyInput("Enter true or false: ")
    );

    database.updateProblem(updatedProblem);
    break;

case 25:
    System.out.println("\n===== DELETE PROBLEM FROM MYSQL =====");

    int deleteId = manager.getInteger("Enter Problem ID to delete: ");

    database.deleteProblem(deleteId);
    break;

case 26:
    int solvedId = manager.getInteger("Enter Problem ID: ");
    database.markSolved(solvedId);
    break;

case 27:
    int unsolvedId = manager.getInteger("Enter Problem ID: ");
    database.markUnsolved(unsolvedId);
    break;

case 28:
    String searchCompany = manager.getNonEmptyInput("Enter Company: ");
    database.searchByCompany(searchCompany);
    break;

case 29:
    String searchTopic = manager.getNonEmptyInput("Enter Topic: ");
    database.searchByTopic(searchTopic);
    break;

case 30:
    String searchDifficulty = manager.getDifficulty();
    database.searchByDifficulty(searchDifficulty);
    break;

case 31:
    String status = manager.getNonEmptyInput(
            "Enter Status (Solved/Unsolved): "
    );

    if (status.equalsIgnoreCase("Solved")) {
        database.searchByStatus(true);
    } else if (status.equalsIgnoreCase("Unsolved")) {
        database.searchByStatus(false);
    } else {
        System.out.println("Invalid status!");
    }
    break;

case 32:
    System.out.println(
            "Thank you for using Student Placement Tracker!"
    );
    break;

                default:

                    System.out.println(
                            "Invalid choice! Please select 1-15."
                    );
            }

        } while (choice != 32);
    }
}


