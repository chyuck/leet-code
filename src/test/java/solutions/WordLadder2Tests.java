package solutions;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class WordLadder2Tests {

    @Test public void testExample1() {
        // arrange
        final var solution = new WordLadder2();

        // act
        final var results = solution.findLadders("hit", "cog", List.of("hot","dot","dog","lot","log","cog"));

        // assert
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(List.of("hit","hot","dot","dog","cog"), results.get(0));
        assertEquals(List.of("hit","hot","lot","log","cog"), results.get(1));
    }

    @Test public void testExample2() {
        // arrange
        final var solution = new WordLadder2();

        // act
        final var results = solution.findLadders("hit", "cog", List.of("hot","dot","dog","lot","log"));

        // assert
        assertNotNull(results);
        assertEquals(0, results.size());
    }

    @Test public void testCase1() {
        // arrange
        final var solution = new WordLadder2();

        // act
        final var results = solution.findLadders("a", "c", List.of("a", "b", "c"));

        // assert
        assertNotNull(results);
        assertEquals(1, results.size());
        assertEquals(List.of("a", "c"), results.get(0));
    }
}
