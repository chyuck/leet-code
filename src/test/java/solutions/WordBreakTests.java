package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class WordBreakTests {

    @Test public void testExample1() {
        // arrange
        var solution = new WordBreak();

        // act
        var result = solution.wordBreak("leetcode", List.of("leet", "code"));

        // assert
        assertTrue(result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new WordBreak();

        // act
        var result = solution.wordBreak("applepenapple", List.of("apple", "pen"));

        // assert
        assertTrue(result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new WordBreak();

        // act
        var result = solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"));

        // assert
        assertFalse(result);
    }
}
