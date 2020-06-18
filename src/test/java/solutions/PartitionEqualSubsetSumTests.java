package solutions;

import org.junit.Assert;
import org.junit.Test;

public class PartitionEqualSubsetSumTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new PartitionEqualSubsetSum();

        // act
        var result = solution.canPartition(new int[] { 1, 5, 11, 5 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new PartitionEqualSubsetSum();

        // act
        var result = solution.canPartition(new int[] { 1, 2, 3, 5 });

        // assert
        Assert.assertFalse(result);
    }
}
