package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class WordSearchTests {

    private char[][] board = new char[][] {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
    };

    @Test public void testExample1() {
        // arrange
        var solution = new WordSearch();

        // act
        var result = solution.exist(board, "ABCCED");

        // assert
        assertTrue(result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new WordSearch();

        // act
        var result = solution.exist(board, "SEE");

        // assert
        assertTrue(result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new WordSearch();

        // act
        var result = solution.exist(board, "ABCB");

        // assert
        assertFalse(result);
    }

    @Test public void testCase1() {
        // arrange
        var solution = new WordSearch();

        // act
        var result = solution.exist(board, "A");

        // assert
        assertTrue(result);
    }
}
