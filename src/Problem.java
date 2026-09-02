public class Problem {

    int id;
    String name;
    String category;
    String difficulty;
    String company;
    String topic;
    boolean solved;

    // Constructor for new problem
    Problem(int id, String name, String category,
            String difficulty, String company,
            String topic) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.company = company;
        this.topic = topic;
        this.solved = false;
    }

    // Constructor for loading from file
    Problem(int id, String name, String category,
            String difficulty, String company,
            String topic, boolean solved) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.company = company;
        this.topic = topic;
        this.solved = solved;
    }

    // Display problem
    void display() {

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

    // Convert problem to file format
    String toFileFormat() {

        return id + "|" +
               name + "|" +
               category + "|" +
               difficulty + "|" +
               company + "|" +
               topic + "|" +
               solved;
    }
}