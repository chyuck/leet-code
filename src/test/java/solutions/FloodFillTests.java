package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class FloodFillTests {

    @Test public void testExample() {
        // arrange
        var image = new int[][] {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };

        var solution = new FloodFill();

        // act
        var result = solution.floodFill(image, 1,1, 2);

        // assert
        var expected = new int[][] {
                {2,2,2},
                {2,2,0},
                {2,0,1}
        };

        assertArrayEquals(expected, result);
    }

    @Test public void testCase() {
        // arrange
        var image = new int[][] {
                {0,0,0},
                {0,1,1}
        };

        var solution = new FloodFill();

        // act
        var result = solution.floodFill(image, 1,1, 1);

        // assert
        var expected = new int[][] {
                {0,0,0},
                {0,1,1}
        };

        assertArrayEquals(expected, result);
    }
}
