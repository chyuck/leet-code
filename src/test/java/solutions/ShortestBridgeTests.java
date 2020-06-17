package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortestBridgeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ShortestBridge();

        // act
        var result = solution.shortestBridge(new int[][] {{0, 1}, {1, 0}});

        // assert
        assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ShortestBridge();
        var input = new int[][] {
                {0,1,0},
                {0,0,0},
                {0,0,1}
        };

        // act
        var result = solution.shortestBridge(input);

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new ShortestBridge();
        var input = new int[][] {
                {1,1,1,1,1},
                {1,0,0,0,1},
                {1,0,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}
        };

        // act
        var result = solution.shortestBridge(input);

        // assert
        assertEquals(1, result);
    }
}
