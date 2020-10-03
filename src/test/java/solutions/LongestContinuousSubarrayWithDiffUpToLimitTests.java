package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LongestContinuousSubarrayWithDiffUpToLimitTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new LongestContinuousSubarrayWithDiffUpToLimit();

        // act
        var result = solution.longestSubarray(new int[] { 8,2,4,7 }, 4);

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new LongestContinuousSubarrayWithDiffUpToLimit();

        // act
        var result = solution.longestSubarray(new int[] { 10,1,2,4,7,2 }, 5);

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new LongestContinuousSubarrayWithDiffUpToLimit();

        // act
        var result = solution.longestSubarray(new int[] { 4,2,2,2,4,4,2,2 }, 0);

        // assert
        Assert.assertEquals(3, result);
    }
}
