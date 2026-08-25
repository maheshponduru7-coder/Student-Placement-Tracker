

public class Problem {

    int id;
    String name;
    String category;
    String difficulty;
    boolean solved;

    public Problem(int id, String name, String category, String difficulty) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.solved = false;
    }

    public Problem(int id, String name, String category,
                   String difficulty, boolean solved) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.difficulty = difficulty;
        this.solved = solved;
    }

    public void display() {

        System.out.println(
                id + " | " +
                name + " | " +
                category + " | " +
                difficulty + " | " +
                (solved ? "Solved" : "Not Solved")
        );
    }

    public String toFileFormat() {

        return id + "|" +
                name + "|" +
                category + "|" +
                difficulty + "|" +
                solved;
    }
}