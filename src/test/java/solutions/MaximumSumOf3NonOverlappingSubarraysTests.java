package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSumOf3NonOverlappingSubarraysTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaximumSumOf3NonOverlappingSubarrays();

        // act
        var results = solution.maxSumOfThreeSubarrays(new int[] { 1,2,1,2,6,7,5,1 }, 2);

        // assert
        Assert.assertArrayEquals(new int[] { 0, 3, 5 }, results);
    }
}
