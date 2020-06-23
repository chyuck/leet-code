package solutions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ContinuousSubarraySumTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ContinuousSubarraySum();

        // act
        var result = solution.checkSubarraySum(new int[] { 23, 2, 4, 6, 7 }, 6);

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ContinuousSubarraySum();

        // act
        var result = solution.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6);

        // assert
        assertTrue(result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new ContinuousSubarraySum();

        // act
        var result = solution.checkSubarraySum(new int[] { 1, 0, 0 }, 0);

        // assert
        assertTrue(result);
    }

    @Test
    public void testCase2() {
        // arrange
        var solution = new ContinuousSubarraySum();

        // act
        var result = solution.checkSubarraySum(new int[] { 1, 1 }, 2);

        // assert
        assertTrue(result);
    }

    @Test
    public void testCase3() {
        // arrange
        var solution = new ContinuousSubarraySum();

        // act
        var result = solution.checkSubarraySum(new int[] { 0, 0 }, 1);

        // assert
        assertTrue(result);
    }
}
