package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class WordBreak2Tests {

    @Test public void testExample1() {
        // arrange
        final var solution = new WordBreak2();

        // act
        final var results = solution.wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"));

        // assert
        assertEquals(2, results.size());
        assertTrue(results. contains("cats and dog"));
        assertTrue(results. contains("cat sand dog"));
    }

    @Test public void testExample2() {
        // arrange
        final var solution = new WordBreak2();

        // act
        final var results = solution.wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"));

        // assert
        assertEquals(3, results.size());
        assertTrue(results. contains("pine apple pen apple"));
        assertTrue(results. contains("pineapple pen apple"));
        assertTrue(results. contains("pine applepen apple"));
    }

    @Test public void testExample3() {
        // arrange
        final var solution = new WordBreak2();

        // act
        final var results = solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"));

        // assert
        assertEquals(0, results.size());
    }
}
