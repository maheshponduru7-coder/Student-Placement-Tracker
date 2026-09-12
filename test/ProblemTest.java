import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ProblemTest {

    @Test
    public void testProblemCreation() {

        Problem problem = new Problem(
                1,
                "Two Sum",
                "Arrays",
                "Easy",
                "Amazon",
                "Hashing"
        );

        assertEquals(1, problem.id);
        assertEquals("Two Sum", problem.name);
        assertEquals("Arrays", problem.category);
        assertEquals("Easy", problem.difficulty);
        assertEquals("Amazon", problem.company);
        assertEquals("Hashing", problem.topic);
        assertFalse(problem.solved);
    }
    @Test
public void testSolvedProblem() {

    Problem problem = new Problem(
            2,
            "Binary Search",
            "Searching",
            "Easy",
            "Google",
            "Binary Search",
            true
    );

    assertTrue(problem.solved);
    assertEquals(2, problem.id);
    assertEquals("Binary Search", problem.name);
    assertEquals("Google", problem.company);
}
}
