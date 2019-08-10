package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class KthLargestElementInArrayTests {

    @Test public void testExample1ForSolution1() {
        // arrange
        var input = new int[] { 3,2,1,5,6,4 };

        var solution = new KthLargestElementInArray();

        // act
        var result = solution.findKthLargest(input, 2);

        // assert
        assertEquals(5, result);
    }

    @Test public void testExample2ForSolution1() {
        // arrange
        var input = new int[] { 3,2,3,1,2,4,5,5,6 };

        var solution = new KthLargestElementInArray();

        // act
        var result = solution.findKthLargest(input, 4);

        // assert
        assertEquals(4, result);
    }

    @Test public void testExample1ForSolution2() {
        // arrange
        var input = new int[] { 3,2,1,5,6,4 };

        var solution = new KthLargestElementInArray();

        // act
        var result = solution.findKthLargest2(input, 2);

        // assert
        assertEquals(5, result);
    }

    @Test public void testExample2ForSolution2() {
        // arrange
        var input = new int[] { 3,2,3,1,2,4,5,5,6 };

        var solution = new KthLargestElementInArray();

        // act
        var result = solution.findKthLargest2(input, 4);

        // assert
        assertEquals(4, result);
    }
}
