package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeIntervalsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MergeIntervals();

        // act
        var result = solution.merge(new int[][] { {1,3},{2,6},{8,10},{15,18} });

        // assert
        assertArrayEquals(new int[][] { {1,6},{8,10},{15,18} }, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MergeIntervals();

        // act
        var result = solution.merge(new int[][] { {1,4},{4,5} });

        // assert
        assertArrayEquals(new int[][] { {1,5} }, result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new MergeIntervals();

        // act
        var result = solution.merge(new int[][] { {1,4},{2,3} });

        // assert
        assertArrayEquals(new int[][] { {1,4} }, result);
    }
}
