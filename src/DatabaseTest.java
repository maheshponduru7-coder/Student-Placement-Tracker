public class DatabaseTest {

    public static void main(String[] args) {

        DatabaseManager database = new DatabaseManager();

        // Delete problem with ID 7
        database.deleteProblem(7);

        // Display remaining problems
        database.displayAllProblems();
    }
}