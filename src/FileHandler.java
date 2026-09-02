import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "data/problems.txt";

    // Save problems to file
    public static void saveProblems(ArrayList<Problem> problems) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Problem problem : problems) {
                writer.write(problem.toFileFormat());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving problems: " + e.getMessage());
        }
    }

    // Load problems from file
    public static ArrayList<Problem> loadProblems() {

        ArrayList<Problem> problems = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return problems;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] data = line.split("\\|");

                if (data.length == 7) {

                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String category = data[2];
                    String difficulty = data[3];
                    String company = data[4];
                    String topic = data[5];
                    boolean solved = Boolean.parseBoolean(data[6]);

                    Problem problem = new Problem(
                            id,
                            name,
                            category,
                            difficulty,
                            company,
                            topic,
                            solved
                    );

                    problems.add(problem);
                }
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading problems: " + e.getMessage());
        }

        return problems;
    }
}