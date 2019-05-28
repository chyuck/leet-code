package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberOfIslandsTests {

    @Test public void testExample1() {
        // arrange
        final var input = new char[][] {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        final var solution = new NumberOfIslands();

        // act
        final var result = solution.numIslands(input);

        // assert
        assertEquals(1, result);
    }

    @Test public void testExample2() {
        // arrange
        final var input = new char[][] {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        final var solution = new NumberOfIslands();

        // act
        final var result = solution.numIslands(input);

        // assert
        assertEquals(3, result);
    }
}
