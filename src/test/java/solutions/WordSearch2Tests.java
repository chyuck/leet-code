package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearch2Tests {

    private final char[][] board = new char[][] {
            {'o','a','a','n'},
            {'e','t','a','e'},
            {'i','h','k','r'},
            {'i','f','l','v'}
    };

    @Test public void testExampleForSolution1() {
        // arrange
        var solution = new WordSearch2();

        // act
        var results = solution.findWords(board, new String[] {"oath","pea","eat","rain"});

        // assert
        assertEquals(2, results.size());
        assertTrue(results.contains("eat"));
        assertTrue(results.contains("oath"));
    }

    @Test public void testCaseForSolution1() {
        // arrange
        var solution = new WordSearch2();

        // act
        var results = solution.findWords(board, new String[] {"oath","oat","oathi"});

        // assert
        assertEquals(3, results.size());
        assertTrue(results.contains("oat"));
        assertTrue(results.contains("oath"));
        assertTrue(results.contains("oathi"));
    }

    @Test public void testExampleForSolution2() {
        // arrange
        var solution = new WordSearch2();

        // act
        var results = solution.findWords2(board, new String[] {"oath","pea","eat","rain"});

        // assert
        assertEquals(2, results.size());
        assertTrue(results.contains("eat"));
        assertTrue(results.contains("oath"));
    }

    @Test public void testCaseForSolution2() {
        // arrange
        var solution = new WordSearch2();

        // act
        var results = solution.findWords2(board, new String[] {"oath","oat","oathi"});

        // assert
        assertEquals(3, results.size());
        assertTrue(results.contains("oat"));
        assertTrue(results.contains("oath"));
        assertTrue(results.contains("oathi"));
    }
}
