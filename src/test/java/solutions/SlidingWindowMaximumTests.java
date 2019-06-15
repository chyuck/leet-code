package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class SlidingWindowMaximumTests {

    @Test public void testExampleForSolution1() {
        // arrange
        var solution = new SlidingWindowMaximum();

        // act
        var result = solution.maxSlidingWindow(new int[] { 1,3,-1,-3,5,3,6,7 }, 3);

        // assert
        assertArrayEquals(new int[] { 3,3,5,5,6,7 }, result);
    }

    @Test public void testCaseForSolution1() {
        // arrange
        var solution = new SlidingWindowMaximum();

        // act
        var result = solution.maxSlidingWindow(new int[] { 1,3,1,2,0,5 }, 3);

        // assert
        assertArrayEquals(new int[] { 3,3,2,5 }, result);
    }

    @Test public void testExampleForSolution2() {
        // arrange
        var solution = new SlidingWindowMaximum();

        // act
        var result = solution.maxSlidingWindow2(new int[] { 1,3,-1,-3,5,3,6,7 }, 3);

        // assert
        assertArrayEquals(new int[] { 3,3,5,5,6,7 }, result);
    }
}
