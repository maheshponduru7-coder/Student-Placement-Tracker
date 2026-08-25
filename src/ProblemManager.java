

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class ProblemManager {

    private ArrayList<Problem> problems = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private static final String FILE_NAME = "data/problems.txt";


    // ==================================================
    // INPUT VALIDATION
    // ==================================================

    public int getInteger(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input! Please enter a number."
                );
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

            String difficulty =
                    getNonEmptyInput(
                            "Enter Difficulty (Easy/Medium/Hard): "
                    );

            if (difficulty.equalsIgnoreCase("Easy")) {

                return "Easy";
            }

            if (difficulty.equalsIgnoreCase("Medium")) {

                return "Medium";
            }

            if (difficulty.equalsIgnoreCase("Hard")) {

                return "Hard";
            }

            System.out.println(
                    "Invalid difficulty! Please enter Easy, Medium or Hard."
            );
        }
    }


    public int getMenuChoice() {

        while (true) {

            int choice =
                    getInteger("\nEnter your choice: ");

            if (choice >= 1 && choice <= 10) {

                return choice;
            }

            System.out.println(
                    "Invalid choice! Please select 1-10."
            );
        }
    }


    // ==================================================
    // SAVE PROBLEMS
    // ==================================================

    public void saveProblems() {

        try {

            File folder = new File("data");

            if (!folder.exists()) {

                folder.mkdirs();
            }

            FileWriter writer =
                    new FileWriter(FILE_NAME);

            for (Problem problem : problems) {

                writer.write(
                        problem.toFileFormat() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println(
                    "Error saving problems: " +
                    e.getMessage()
            );
        }
    }


    // ==================================================
    // LOAD PROBLEMS
    // ==================================================

    public void loadProblems() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {

            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(FILE_NAME)
                    );

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {

                    continue;
                }

                String[] data =
                        line.split("\\|");

                if (data.length == 5) {

                    int id =
                            Integer.parseInt(data[0]);

                    String name = data[1];

                    String category = data[2];

                    String difficulty = data[3];

                    boolean solved =
                            Boolean.parseBoolean(data[4]);

                    problems.add(
                            new Problem(
                                    id,
                                    name,
                                    category,
                                    difficulty,
                                    solved
                            )
                    );
                }
            }

            reader.close();

        } catch (IOException |
                 NumberFormatException e) {

            System.out.println(
                    "Error loading problems: " +
                    e.getMessage()
            );
        }
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


        problems.add(
                new Problem(
                        id,
                        name,
                        category,
                        difficulty
                )
        );


        saveProblems();


        System.out.println(
                "Problem added successfully!"
        );
    }


    // ==================================================
    // DISPLAY PROBLEMS
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


    // ==================================================
    // MARK SOLVED
    // ==================================================

    public void markSolved() {

        System.out.println(
                "\n===== MARK PROBLEM SOLVED ====="
        );

        int id =
                getInteger(
                        "Enter Problem ID: "
                );


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
                getInteger(
                        "Enter Problem ID: "
                );


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
                getInteger(
                        "Enter Problem ID: "
                );


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
                getInteger(
                        "Enter Problem ID: "
                );


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
    // BETTER PROGRESS
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


        // Count problems
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


        int unsolved =
                total - solved;


        double overallPercentage =
                ((double) solved / total) * 100;


        double easyPercentage = 0;

        if (easyTotal > 0) {

            easyPercentage =
                    ((double) easySolved /
                            easyTotal) * 100;
        }


        double mediumPercentage = 0;

        if (mediumTotal > 0) {

            mediumPercentage =
                    ((double) mediumSolved /
                            mediumTotal) * 100;
        }


        double hardPercentage = 0;

        if (hardTotal > 0) {

            hardPercentage =
                    ((double) hardSolved /
                            hardTotal) * 100;
        }


        // ================= OVERALL =================

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


        // ================= DIFFICULTY =================

        System.out.println(
                "\n----- DIFFICULTY WISE -----"
        );


        System.out.println(
                "\nEasy"
        );

        System.out.println(
                "  Total    : " + easyTotal
        );

        System.out.println(
                "  Solved   : " + easySolved
        );

        System.out.println(
                "  Unsolved : " +
                        (easyTotal - easySolved)
        );

        System.out.printf(
                "  Progress : %.2f%%\n",
                easyPercentage
        );


        System.out.println(
                "\nMedium"
        );

        System.out.println(
                "  Total    : " + mediumTotal
        );

        System.out.println(
                "  Solved   : " + mediumSolved
        );

        System.out.println(
                "  Unsolved : " +
                        (mediumTotal - mediumSolved)
        );

        System.out.printf(
                "  Progress : %.2f%%\n",
                mediumPercentage
        );


        System.out.println(
                "\nHard"
        );

        System.out.println(
                "  Total    : " + hardTotal
        );

        System.out.println(
                "  Solved   : " + hardSolved
        );

        System.out.println(
                "  Unsolved : " +
                        (hardTotal - hardSolved)
        );

        System.out.printf(
                "  Progress : %.2f%%\n",
                hardPercentage
        );


        System.out.println(
                "\n=============================="
        );
    }
}
