import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    public void addProblem(Problem problem) {

        String sql = "INSERT INTO problems " +
                     "(id, name, category, difficulty, company, topic, solved) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, problem.id);
            statement.setString(2, problem.name);
            statement.setString(3, problem.category);
            statement.setString(4, problem.difficulty);
            statement.setString(5, problem.company);
            statement.setString(6, problem.topic);
            statement.setBoolean(7, problem.solved);

            statement.executeUpdate();

            System.out.println("Problem added to database successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding problem: " + e.getMessage());
        }
    }
    public void displayAllProblems() {

    String sql = "SELECT * FROM problems";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         var resultSet = statement.executeQuery()) {

        System.out.println("\n===== ALL PROBLEMS FROM DATABASE =====");
        System.out.println(
                "ID | Name | Category | Difficulty | Company | Topic | Status"
        );

        while (resultSet.next()) {

            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String category = resultSet.getString("category");
            String difficulty = resultSet.getString("difficulty");
            String company = resultSet.getString("company");
            String topic = resultSet.getString("topic");
            boolean solved = resultSet.getBoolean("solved");

            System.out.println(
                    id + " | " +
                    name + " | " +
                    category + " | " +
                    difficulty + " | " +
                    company + " | " +
                    topic + " | " +
                    (solved ? "Solved" : "Not Solved")
            );
        }

    } catch (SQLException e) {
        System.out.println("Error displaying problems: " + e.getMessage());
    }
}

public void updateProblem(Problem problem) {

    String sql = "UPDATE problems SET name = ?, category = ?, " +
                 "difficulty = ?, company = ?, topic = ?, solved = ? " +
                 "WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, problem.name);
        statement.setString(2, problem.category);
        statement.setString(3, problem.difficulty);
        statement.setString(4, problem.company);
        statement.setString(5, problem.topic);
        statement.setBoolean(6, problem.solved);
        statement.setInt(7, problem.id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Problem updated successfully!");
        } else {
            System.out.println("Problem not found.");
        }

    } catch (SQLException e) {
        System.out.println("Error updating problem: " + e.getMessage());
    }
}

public void deleteProblem(int id) {

    String sql = "DELETE FROM problems WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Problem deleted successfully!");
        } else {
            System.out.println("Problem not found.");
        }

    } catch (SQLException e) {
        System.out.println("Error deleting problem: " + e.getMessage());
    }
}
public void markSolved(int id) {

    String sql = "UPDATE problems SET solved = TRUE WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Problem marked as solved in MySQL!");
        } else {
            System.out.println("Problem not found.");
        }

    } catch (SQLException e) {
        System.out.println("Error updating problem: " + e.getMessage());
    }
}

public void markUnsolved(int id) {

    String sql = "UPDATE problems SET solved = FALSE WHERE id = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, id);

        int rows = statement.executeUpdate();

        if (rows > 0) {
            System.out.println("Problem marked as unsolved in MySQL!");
        } else {
            System.out.println("Problem not found.");
        }

    } catch (SQLException e) {
        System.out.println("Error updating problem: " + e.getMessage());
    }
}
public void searchByCompany(String company) {

    String sql = "SELECT * FROM problems WHERE company = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, company);

        var resultSet = statement.executeQuery();

        boolean found = false;

        while (resultSet.next()) {
            found = true;

            System.out.println(
                    resultSet.getInt("id") + " | " +
                    resultSet.getString("name") + " | " +
                    resultSet.getString("category") + " | " +
                    resultSet.getString("difficulty") + " | " +
                    resultSet.getString("company") + " | " +
                    resultSet.getString("topic") + " | " +
                    (resultSet.getBoolean("solved") ? "Solved" : "Not Solved")
            );
        }

        if (!found) {
            System.out.println("No problems found for this company.");
        }

    } catch (SQLException e) {
        System.out.println("Error searching by company: " + e.getMessage());
    }
}

public void searchByTopic(String topic) {

    String sql = "SELECT * FROM problems WHERE topic = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, topic);

        var resultSet = statement.executeQuery();

        boolean found = false;

        while (resultSet.next()) {
            found = true;

            System.out.println(
                    resultSet.getInt("id") + " | " +
                    resultSet.getString("name") + " | " +
                    resultSet.getString("category") + " | " +
                    resultSet.getString("difficulty") + " | " +
                    resultSet.getString("company") + " | " +
                    resultSet.getString("topic") + " | " +
                    (resultSet.getBoolean("solved") ? "Solved" : "Not Solved")
            );
        }

        if (!found) {
            System.out.println("No problems found for this topic.");
        }

    } catch (SQLException e) {
        System.out.println("Error searching by topic: " + e.getMessage());
    }
}

public void searchByDifficulty(String difficulty) {

    String sql = "SELECT * FROM problems WHERE difficulty = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, difficulty);

        var resultSet = statement.executeQuery();

        boolean found = false;

        while (resultSet.next()) {
            found = true;

            System.out.println(
                    resultSet.getInt("id") + " | " +
                    resultSet.getString("name") + " | " +
                    resultSet.getString("category") + " | " +
                    resultSet.getString("difficulty") + " | " +
                    resultSet.getString("company") + " | " +
                    resultSet.getString("topic") + " | " +
                    (resultSet.getBoolean("solved") ? "Solved" : "Not Solved")
            );
        }

        if (!found) {
            System.out.println("No problems found for this difficulty.");
        }

    } catch (SQLException e) {
        System.out.println("Error searching by difficulty: " + e.getMessage());
    }
}

public void searchByStatus(boolean solved) {

    String sql = "SELECT * FROM problems WHERE solved = ?";

    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setBoolean(1, solved);

        var resultSet = statement.executeQuery();

        boolean found = false;

        while (resultSet.next()) {
            found = true;

            System.out.println(
                    resultSet.getInt("id") + " | " +
                    resultSet.getString("name") + " | " +
                    resultSet.getString("category") + " | " +
                    resultSet.getString("difficulty") + " | " +
                    resultSet.getString("company") + " | " +
                    resultSet.getString("topic") + " | " +
                    (resultSet.getBoolean("solved") ? "Solved" : "Not Solved")
            );
        }

        if (!found) {
            System.out.println("No problems found for this status.");
        }

    } catch (SQLException e) {
        System.out.println("Error searching by status: " + e.getMessage());
    }
}
}
