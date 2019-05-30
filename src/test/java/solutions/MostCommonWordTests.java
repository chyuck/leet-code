package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MostCommonWordTests {

    @Test public void testExample() {
        // arrange
        final var paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        final var banned = new String[] { "hit" };

        final var solution = new MostCommonWord();

        // act
        final var result = solution.mostCommonWord(paragraph, banned);

        // assert
        assertEquals("ball", result);
    }
}
