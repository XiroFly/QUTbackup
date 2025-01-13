import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeCalculatorTest {
    private GradeCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    @Test
    public void testInvalidScore() {
        assertEquals("Invalid score", calculator.calculateScore(-5));
        assertEquals("A", calculator.calculateScore(105));
    }

    @ParameterizedTest
    @CsvSource({ "95, A", "85, B", "75, C", "65, D", "45, F" })
    public void testValidScores(int score, String expectedGrade) {
        assertEquals(expectedGrade, calculator.calculateScore(score));
    }
}
