import java.util.*;

public class ProblemManager {

    private ArrayList<Problem> problems = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private static final String FILE_NAME = "data/problems.txt";


    // ==================================================
    // INPUT VALIDATION
    // ==================================================

    public int getInteger(String message) {

    while (true) {

        try {
            System.out.print(message);
            return Integer.parseInt(scanner.nextLine().trim());

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a number.");
        }
    }
}


    public String getNonEmptyInput(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println(
                    "Input cannot be empty. Please try again."
            );
        }
    }
    

    public String getDifficulty() {

    while (true) {

        System.out.print("Enter Difficulty (Easy/Medium/Hard): ");

        String difficulty = scanner.nextLine().trim();

        if (difficulty.equalsIgnoreCase("Easy") ||
            difficulty.equalsIgnoreCase("Medium") ||
            difficulty.equalsIgnoreCase("Hard")) {

            return difficulty;
        }

        System.out.println(
            "Invalid difficulty! Choose Easy, Medium, or Hard."
        );
    }
}

    public int getMenuChoice() {

    while (true) {

        try {
            System.out.print("Enter your choice: ");
            return Integer.parseInt(scanner.nextLine().trim());

        } catch (NumberFormatException e) {
            System.out.println("Invalid choice! Please enter a number.");
        }
    }
}


    // ==================================================
    // FILE HANDLING
    // ==================================================

public void saveProblems() {
    FileHandler.saveProblems(problems);
}


   public void loadProblems() {
    problems = FileHandler.loadProblems();
}

    // ==================================================
    // ADD PROBLEM
    // ==================================================

   public void addProblem() {

    System.out.println(
            "\n===== ADD PROBLEM ====="
    );

    int id =
            getInteger("Enter Problem ID: ");

    // Check duplicate ID
    for (Problem problem : problems) {

        if (problem.id == id) {

            System.out.println(
                    "Problem ID already exists!"
            );

            return;
        }
    }

    String name =
            getNonEmptyInput(
                    "Enter Problem Name: "
            );

    String category =
            getNonEmptyInput(
                    "Enter Category: "
            );

    String difficulty =
            getDifficulty();

    String company =
            getNonEmptyInput(
                    "Enter Company: "
            );

    String topic =
            getNonEmptyInput(
                    "Enter Topic: "
            );

    problems.add(
            new Problem(
                    id,
                    name,
                    category,
                    difficulty,
                    company,
                    topic
            )
    );

    saveProblems();

    System.out.println(
            "Problem added successfully!"
    );
}
    // ==================================================
    // DISPLAY ALL PROBLEMS
    // ==================================================

    public void displayProblems() {

        System.out.println(
                "\n===== ALL PROBLEMS ====="
        );

        if (problems.isEmpty()) {

            System.out.println(
                    "No problems available."
            );

            return;
        }

        displayList(problems);
    }


    // ==================================================
    // DISPLAY LIST
    // ==================================================

   private void displayList(
        ArrayList<Problem> list) {

    System.out.println(
            "ID | Name | Category | Difficulty | Company | Topic | Status"
    );

    System.out.println(
            "--------------------------------------------------------------------------"
    );

    for (Problem problem : list) {

        problem.display();
    }
}

    // ==================================================
    // MARK SOLVED
    // ==================================================

    public void markSolved() {

        System.out.println(
                "\n===== MARK PROBLEM SOLVED ====="
        );

        int id =
                getInteger("Enter Problem ID: ");

        for (Problem problem : problems) {

            if (problem.id == id) {

                if (problem.solved) {

                    System.out.println(
                            "Problem is already solved."
                    );

                } else {

                    problem.solved = true;

                    saveProblems();

                    System.out.println(
                            "Problem marked as solved!"
                    );
                }

                return;
            }
        }

        System.out.println(
                "Problem not found."
        );
    }


    // ==================================================
    // MARK UNSOLVED
    // ==================================================

    public void markUnsolved() {

        System.out.println(
                "\n===== MARK PROBLEM UNSOLVED ====="
        );

        int id =
                getInteger("Enter Problem ID: ");

        for (Problem problem : problems) {

            if (problem.id == id) {

                if (!problem.solved) {

                    System.out.println(
                            "Problem is already unsolved."
                    );

                } else {

                    problem.solved = false;

                    saveProblems();

                    System.out.println(
                            "Problem marked as unsolved!"
                    );
                }

                return;
            }
        }

        System.out.println(
                "Problem not found."
        );
    }


    // ==================================================
    // SEARCH BY CATEGORY
    // ==================================================

    public void searchCategory() {

        System.out.println(
                "\n===== SEARCH BY CATEGORY ====="
        );

        String category =
                getNonEmptyInput(
                        "Enter Category: "
                );

        boolean found = false;

        for (Problem problem : problems) {

            if (problem.category
                    .equalsIgnoreCase(category)) {

                problem.display();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No problems found in this category."
            );
        }
    }


    // ==================================================
    // SEARCH BY NAME
    // ==================================================

    public void searchByName() {

        System.out.println(
                "\n===== SEARCH BY NAME ====="
        );

        String name =
                getNonEmptyInput(
                        "Enter Problem Name: "
                );

        boolean found = false;

        for (Problem problem : problems) {

            if (problem.name
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                problem.display();

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No matching problems found."
            );
        }
    }


    // ==================================================
    // UPDATE PROBLEM
    // ==================================================

   public void updateProblem() {

    System.out.println(
            "\n===== UPDATE PROBLEM ====="
    );

    int id =
            getInteger("Enter Problem ID: ");

    for (Problem problem : problems) {

        if (problem.id == id) {

            System.out.println(
                    "\nCurrent Problem:"
            );

            problem.display();

            problem.name =
                    getNonEmptyInput(
                            "Enter New Problem Name: "
                    );

            problem.category =
                    getNonEmptyInput(
                            "Enter New Category: "
                    );

            problem.difficulty =
                    getDifficulty();

            problem.company =
                    getNonEmptyInput(
                            "Enter New Company: "
                    );

            problem.topic =
                    getNonEmptyInput(
                            "Enter New Topic: "
                    );

            saveProblems();

            System.out.println(
                    "Problem updated successfully!"
            );

            return;
        }
    }

    System.out.println(
            "Problem not found."
    );
}

    // ==================================================
    // DELETE PROBLEM
    // ==================================================

    public void deleteProblem() {

        System.out.println(
                "\n===== DELETE PROBLEM ====="
        );

        int id =
                getInteger("Enter Problem ID: ");

        for (int i = 0;
             i < problems.size();
             i++) {

            if (problems.get(i).id == id) {

                System.out.println(
                        "\nProblem to delete:"
                );

                problems.get(i).display();

                String confirmation =
                        getNonEmptyInput(
                                "Are you sure? (yes/no): "
                        );

                if (confirmation.equalsIgnoreCase("yes")) {

                    problems.remove(i);

                    saveProblems();

                    System.out.println(
                            "Problem deleted successfully!"
                    );

                } else {

                    System.out.println(
                            "Delete operation cancelled."
                    );
                }

                return;
            }
        }

        System.out.println(
                "Problem not found."
        );
    }


    // ==================================================
    // FILTER BY DIFFICULTY
    // ==================================================

    public void filterByDifficulty() {

        System.out.println(
                "\n===== FILTER BY DIFFICULTY ====="
        );

        String difficulty =
                getDifficulty();

        ArrayList<Problem> filtered =
                new ArrayList<>();

        for (Problem problem : problems) {

            if (problem.difficulty
                    .equalsIgnoreCase(difficulty)) {

                filtered.add(problem);
            }
        }

        if (filtered.isEmpty()) {

            System.out.println(
                    "No problems found."
            );

            return;
        }

        displayList(filtered);
    }


    // ==================================================
    // FILTER BY STATUS
    // ==================================================

    public void filterByStatus() {

        System.out.println(
                "\n===== FILTER BY STATUS ====="
        );

        System.out.println("1. Solved");
        System.out.println("2. Unsolved");

        int choice =
                getInteger("Enter choice: ");

        if (choice != 1 && choice != 2) {

            System.out.println(
                    "Invalid choice."
            );

            return;
        }

        ArrayList<Problem> filtered =
                new ArrayList<>();

        for (Problem problem : problems) {

            if (choice == 1 && problem.solved) {

                filtered.add(problem);
            }

            else if (choice == 2 && !problem.solved) {

                filtered.add(problem);
            }
        }

        if (filtered.isEmpty()) {

            System.out.println(
                    "No problems found."
            );

            return;
        }

        displayList(filtered);
    }


    // ==================================================
    // SORT BY ID
    // ==================================================

    public void sortById() {

        for (int i = 0;
             i < problems.size() - 1;
             i++) {

            for (int j = 0;
                 j < problems.size() - i - 1;
                 j++) {

                if (problems.get(j).id >
                        problems.get(j + 1).id) {

                    Problem temp =
                            problems.get(j);

                    problems.set(
                            j,
                            problems.get(j + 1)
                    );

                    problems.set(
                            j + 1,
                            temp
                    );
                }
            }
        }

        System.out.println(
                "\nProblems sorted by ID."
        );

        displayList(problems);
    }


    // ==================================================
    // SORT BY DIFFICULTY
    // ==================================================

    public void sortByDifficulty() {

        for (int i = 0;
             i < problems.size() - 1;
             i++) {

            for (int j = 0;
                 j < problems.size() - i - 1;
                 j++) {

                int current =
                        difficultyValue(
                                problems.get(j).difficulty
                        );

                int next =
                        difficultyValue(
                                problems.get(j + 1).difficulty
                        );

                if (current > next) {

                    Problem temp =
                            problems.get(j);

                    problems.set(
                            j,
                            problems.get(j + 1)
                    );

                    problems.set(
                            j + 1,
                            temp
                    );
                }
            }
        }

        System.out.println(
                "\nProblems sorted by difficulty."
        );

        displayList(problems);
    }


    private int difficultyValue(
            String difficulty) {

        if (difficulty.equalsIgnoreCase("Easy")) {
            return 1;
        }

        if (difficulty.equalsIgnoreCase("Medium")) {
            return 2;
        }

        return 3;
    }


    // ==================================================
    // CATEGORY-WISE PROGRESS
    // ==================================================

    public void categoryProgress() {

        System.out.println(
                "\n===== CATEGORY-WISE PROGRESS ====="
        );

        if (problems.isEmpty()) {

            System.out.println(
                    "No problems available."
            );

            return;
        }

        ArrayList<String> categories =
                new ArrayList<>();

        for (Problem problem : problems) {

            boolean exists = false;

            for (String category : categories) {

                if (category.equalsIgnoreCase(
                        problem.category)) {

                    exists = true;
                    break;
                }
            }

            if (!exists) {

                categories.add(
                        problem.category
                );
            }
        }

        for (String category : categories) {

            int total = 0;
            int solved = 0;

            for (Problem problem : problems) {

                if (problem.category
                        .equalsIgnoreCase(category)) {

                    total++;

                    if (problem.solved) {
                        solved++;
                    }
                }
            }

            double percentage =
                    ((double) solved / total) * 100;

            System.out.println(
                    "\nCategory: " + category
            );

            System.out.println(
                    "Total   : " + total
            );

            System.out.println(
                    "Solved  : " + solved
            );

            System.out.println(
                    "Unsolved: " +
                    (total - solved)
            );

            System.out.printf(
                    "Progress: %.2f%%\n",
                    percentage
            );
        }
    }


    // ==================================================
    // BETTER OVERALL PROGRESS
    // ==================================================

    public void showProgress() {

        System.out.println(
                "\n========== PROGRESS =========="
        );

        if (problems.isEmpty()) {

            System.out.println(
                    "No problems available."
            );

            return;
        }

        int total = problems.size();
        int solved = 0;

        int easyTotal = 0;
        int mediumTotal = 0;
        int hardTotal = 0;

        int easySolved = 0;
        int mediumSolved = 0;
        int hardSolved = 0;

        for (Problem problem : problems) {

            if (problem.difficulty
                    .equalsIgnoreCase("Easy")) {

                easyTotal++;

                if (problem.solved) {
                    easySolved++;
                }
            }

            else if (problem.difficulty
                    .equalsIgnoreCase("Medium")) {

                mediumTotal++;

                if (problem.solved) {
                    mediumSolved++;
                }
            }

            else if (problem.difficulty
                    .equalsIgnoreCase("Hard")) {

                hardTotal++;

                if (problem.solved) {
                    hardSolved++;
                }
            }

            if (problem.solved) {
                solved++;
            }
        }

        int unsolved = total - solved;

        double overallPercentage =
                ((double) solved / total) * 100;

        System.out.println(
                "\n----- OVERALL -----"
        );

        System.out.println(
                "Total Problems : " + total
        );

        System.out.println(
                "Solved         : " + solved
        );

        System.out.println(
                "Unsolved       : " + unsolved
        );

        System.out.printf(
                "Progress       : %.2f%%\n",
                overallPercentage
        );

        System.out.println(
                "\n----- DIFFICULTY WISE -----"
        );

        printDifficultyProgress(
                "Easy",
                easyTotal,
                easySolved
        );

        printDifficultyProgress(
                "Medium",
                mediumTotal,
                mediumSolved
        );

        printDifficultyProgress(
                "Hard",
                hardTotal,
                hardSolved
        );

        System.out.println(
                "\n=============================="
        );
    }


    private void printDifficultyProgress(
            String difficulty,
            int total,
            int solved) {

        double percentage = 0;

        if (total > 0) {

            percentage =
                    ((double) solved / total) * 100;
        }

        System.out.println(
                "\n" + difficulty
        );

        System.out.println(
                "  Total    : " + total
        );

        System.out.println(
                "  Solved   : " + solved
        );

        System.out.println(
                "  Unsolved : " + (total - solved)
        );

        System.out.printf(
                "  Progress : %.2f%%\n",
                percentage
        );
    }
    // ==================================================
// STATISTICS DASHBOARD
// ==================================================

public void showDashboard() {

    System.out.println(
            "\n=========================================="
    );

    System.out.println(
            "          PLACEMENT DASHBOARD"
    );

    System.out.println(
            "=========================================="
    );

    if (problems.isEmpty()) {

        System.out.println(
                "No problems available."
        );

        return;
    }

    int total = problems.size();
    int solved = 0;

    for (Problem problem : problems) {

        if (problem.solved) {
            solved++;
        }
    }

    int unsolved = total - solved;

    double percentage =
            ((double) solved / total) * 100;

    // ==========================================
    // OVERALL STATISTICS
    // ==========================================

    System.out.println(
            "\n----- OVERALL STATISTICS -----"
    );

    System.out.println(
            "Total Problems : " + total
    );

    System.out.println(
            "Solved         : " + solved
    );

    System.out.println(
            "Unsolved       : " + unsolved
    );

    System.out.printf(
            "Completion     : %.2f%%\n",
            percentage
    );


    // ==========================================
    // PROGRESS BAR
    // ==========================================

    System.out.print(
            "Progress       : ["
    );

    int completedBars =
            (int) (percentage / 5);

    for (int i = 0; i < 20; i++) {

        if (i < completedBars) {
            System.out.print("#");
        } else {
            System.out.print("-");
        }
    }

    System.out.println("]");


    // ==========================================
    // DIFFICULTY STATISTICS
    // ==========================================

    int easyTotal = 0;
    int easySolved = 0;

    int mediumTotal = 0;
    int mediumSolved = 0;

    int hardTotal = 0;
    int hardSolved = 0;


    for (Problem problem : problems) {

        if (problem.difficulty
                .equalsIgnoreCase("Easy")) {

            easyTotal++;

            if (problem.solved) {
                easySolved++;
            }
        }

        else if (problem.difficulty
                .equalsIgnoreCase("Medium")) {

            mediumTotal++;

            if (problem.solved) {
                mediumSolved++;
            }
        }

        else if (problem.difficulty
                .equalsIgnoreCase("Hard")) {

            hardTotal++;

            if (problem.solved) {
                hardSolved++;
            }
        }
    }


    System.out.println(
            "\n----- DIFFICULTY STATISTICS -----"
    );

    printDashboardDifficulty(
            "Easy",
            easyTotal,
            easySolved
    );

    printDashboardDifficulty(
            "Medium",
            mediumTotal,
            mediumSolved
    );

    printDashboardDifficulty(
            "Hard",
            hardTotal,
            hardSolved
    );


    // ==========================================
    // CATEGORY STATISTICS
    // ==========================================

    System.out.println(
            "\n----- CATEGORY STATISTICS -----"
    );

    ArrayList<String> categories =
            new ArrayList<>();

    for (Problem problem : problems) {

        boolean exists = false;

        for (String category : categories) {

            if (category.equalsIgnoreCase(
                    problem.category)) {

                exists = true;
                break;
            }
        }

        if (!exists) {

            categories.add(
                    problem.category
            );
        }
    }


    String bestCategory = "";
    int bestCategorySolved = -1;


    for (String category : categories) {

        int categoryTotal = 0;
        int categorySolved = 0;

        for (Problem problem : problems) {

            if (problem.category
                    .equalsIgnoreCase(category)) {

                categoryTotal++;

                if (problem.solved) {
                    categorySolved++;
                }
            }
        }

        double categoryPercentage =
                ((double) categorySolved /
                        categoryTotal) * 100;


        System.out.println(
                "\n" + category
        );

        System.out.println(
                "  Total    : " + categoryTotal
        );

        System.out.println(
                "  Solved   : " + categorySolved
        );

        System.out.println(
                "  Unsolved : " +
                (categoryTotal - categorySolved)
        );

        System.out.printf(
                "  Progress : %.2f%%\n",
                categoryPercentage
        );


        if (categorySolved > bestCategorySolved) {

            bestCategorySolved =
                    categorySolved;

            bestCategory = category;
        }
    }


    // ==========================================
    // BEST CATEGORY
    // ==========================================

    System.out.println(
            "\n----- ACHIEVEMENT -----"
    );

    if (!bestCategory.isEmpty()) {

        System.out.println(
                "Most Solved Category : " +
                bestCategory
        );

        System.out.println(
                "Problems Solved      : " +
                bestCategorySolved
        );
    }


    System.out.println(
            "\n=========================================="
    );
}
// ==================================================
// DASHBOARD DIFFICULTY DISPLAY
// ==================================================

private void printDashboardDifficulty(
        String difficulty,
        int total,
        int solved) {

    double percentage = 0;

    if (total > 0) {

        percentage =
                ((double) solved / total) * 100;
    }

    System.out.println(
            "\n" + difficulty
    );

    System.out.println(
            "  Total    : " + total
    );

    System.out.println(
            "  Solved   : " + solved
    );

    System.out.println(
            "  Unsolved : " + (total - solved)
    );

    System.out.printf(
            "  Progress : %.2f%%\n",
            percentage
    );
}
public void searchByCompany() {

    System.out.println(
            "\n===== SEARCH BY COMPANY ====="
    );

    String company =
            getNonEmptyInput(
                    "Enter Company: "
            );

    boolean found = false;

    for (Problem problem : problems) {

        if (problem.company
                .equalsIgnoreCase(company)) {

            problem.display();

            found = true;
        }
    }

    if (!found) {

        System.out.println(
                "No problems found for this company."
        );
    }
}

public void searchByTopic() {

    System.out.println(
            "\n===== SEARCH BY TOPIC ====="
    );

    String topic =
            getNonEmptyInput(
                    "Enter Topic: "
            );

    boolean found = false;

    for (Problem problem : problems) {

        if (problem.topic
                .equalsIgnoreCase(topic)) {

            problem.display();

            found = true;
        }
    }

    if (!found) {

        System.out.println(
                "No problems found for this topic."
        );
    }
}
public void advancedSearch() {

    System.out.println("\n===== ADVANCED SEARCH =====");

    System.out.print("Enter Company (or press Enter to skip): ");
    String company = scanner.nextLine().trim();

    System.out.print("Enter Topic (or press Enter to skip): ");
    String topic = scanner.nextLine().trim();

    System.out.print("Enter Difficulty (Easy/Medium/Hard or press Enter to skip): ");
    String difficulty = scanner.nextLine().trim();

    System.out.print("Enter Status (Solved/Unsolved or press Enter to skip): ");
    String status = scanner.nextLine().trim();

    boolean found = false;

    System.out.println("\n===== SEARCH RESULTS =====");

    for (Problem problem : problems) {

        boolean matches = true;

        // Company filter
        if (!company.isEmpty() &&
            !problem.company.equalsIgnoreCase(company)) {
            matches = false;
        }

        // Topic filter
        if (!topic.isEmpty() &&
            !problem.topic.equalsIgnoreCase(topic)) {
            matches = false;
        }

        // Difficulty filter
        if (!difficulty.isEmpty() &&
            !problem.difficulty.equalsIgnoreCase(difficulty)) {
            matches = false;
        }

        // Status filter
        if (!status.isEmpty()) {

            if (status.equalsIgnoreCase("Solved") && !problem.solved) {
                matches = false;
            }

            if (status.equalsIgnoreCase("Unsolved") && problem.solved) {
                matches = false;
            }
        }

        if (matches) {
            problem.display();
            found = true;
        }
    }

    if (!found) {
        System.out.println("No problems match the given filters.");
    }
}
public void searchByIdUsingHashMap() {

    System.out.println("\n===== SEARCH BY ID =====");

    int id = getInteger("Enter Problem ID: ");

    HashMap<Integer, Problem> problemMap = new HashMap<>();

    // Store problems in HashMap
    for (Problem problem : problems) {
        problemMap.put(problem.id, problem);
    }

    // Fast lookup using ID
    Problem problem = problemMap.get(id);

    if (problem != null) {
        System.out.println("\nProblem Found:");
        problem.display();
    } else {
        System.out.println("No problem found with ID " + id);
    }
}
public void showUniqueCompaniesAndTopics() {

    System.out.println("\n===== UNIQUE COMPANIES & TOPICS =====");

    HashSet<String> companies = new HashSet<>();
    HashSet<String> topics = new HashSet<>();

    for (Problem problem : problems) {
        companies.add(problem.company);
        topics.add(problem.topic);
    }

    System.out.println("\nCompanies:");

    for (String company : companies) {
        System.out.println("- " + company);
    }

    System.out.println("\nTopics:");

    for (String topic : topics) {
        System.out.println("- " + topic);
    }
}
public void advancedStatistics() {

    System.out.println("\n===== ADVANCED STATISTICS =====");

    HashMap<String, Integer> difficultyCount = new HashMap<>();
    HashMap<String, Integer> companyCount = new HashMap<>();
    HashMap<String, Integer> topicCount = new HashMap<>();

    HashMap<String, Integer> solvedCompanyCount = new HashMap<>();
    HashMap<String, Integer> solvedTopicCount = new HashMap<>();

    for (Problem problem : problems) {

        // Difficulty count
        difficultyCount.put(
                problem.difficulty,
                difficultyCount.getOrDefault(problem.difficulty, 0) + 1
        );

        // Company count
        companyCount.put(
                problem.company,
                companyCount.getOrDefault(problem.company, 0) + 1
        );

        // Topic count
        topicCount.put(
                problem.topic,
                topicCount.getOrDefault(problem.topic, 0) + 1
        );

        // Solved company count
        if (problem.solved) {
            solvedCompanyCount.put(
                    problem.company,
                    solvedCompanyCount.getOrDefault(problem.company, 0) + 1
            );

            // Solved topic count
            solvedTopicCount.put(
                    problem.topic,
                    solvedTopicCount.getOrDefault(problem.topic, 0) + 1
            );
        }
    }

    System.out.println("\n--- Problems by Difficulty ---");
    displayStatistics(difficultyCount);

    System.out.println("\n--- Problems by Company ---");
    displayStatistics(companyCount);

    System.out.println("\n--- Problems by Topic ---");
    displayStatistics(topicCount);

    System.out.println("\n--- Solved Problems by Company ---");
    displayStatistics(solvedCompanyCount);

    System.out.println("\n--- Solved Problems by Topic ---");
    displayStatistics(solvedTopicCount);

    System.out.println("\n--- Most Common Company ---");
    System.out.println(findMaximum(companyCount));

    System.out.println("\n--- Most Common Topic ---");
    System.out.println(findMaximum(topicCount));
}
private void displayStatistics(HashMap<String, Integer> map) {

    for (String key : map.keySet()) {
        System.out.println(key + " : " + map.get(key));
    }
}
private String findMaximum(HashMap<String, Integer> map) {

    if (map.isEmpty()) {
        return "No data available";
    }

    String maximumKey = "";
    int maximumValue = 0;

    for (String key : map.keySet()) {

        if (map.get(key) > maximumValue) {
            maximumValue = map.get(key);
            maximumKey = key;
        }
    }

    return maximumKey + " : " + maximumValue + " problems";
}
}

