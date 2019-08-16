package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class Search2dMatrix2Tests {

    private final int[][] matrix = new int[][] {
            {1,   4,  7, 11, 15},
            {2,   5,  8, 12, 19},
            {3,   6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}};

    @Test public void testExample1() {
        // arrange
        var solution = new Search2dMatrix2();

        // act
        var result = solution.searchMatrix(matrix, 5);

        // assert
        assertTrue(result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new Search2dMatrix2();

        // act
        var result = solution.searchMatrix(matrix, 20);

        // assert
        assertFalse(result);
    }
}
