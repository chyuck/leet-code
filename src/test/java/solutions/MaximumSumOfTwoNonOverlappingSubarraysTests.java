package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumOfTwoNonOverlappingSubarraysTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumSumOfTwoNonOverlappingSubarrays();

        // act
        var result = solution.maxSumTwoNoOverlap(new int[] { 0,6,5,2,2,5,1,9,4 }, 1, 2);

        // assert
        Assert.assertEquals(20, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MaximumSumOfTwoNonOverlappingSubarrays();

        // act
        var result = solution.maxSumTwoNoOverlap(new int[] { 3,8,1,3,2,1,8,9,0 }, 3, 2);

        // assert
        Assert.assertEquals(29, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new MaximumSumOfTwoNonOverlappingSubarrays();

        // act
        var result = solution.maxSumTwoNoOverlap(new int[] { 2,1,5,6,0,9,5,0,3,8 }, 4, 3);

        // assert
        Assert.assertEquals(31, result);
    }
}
