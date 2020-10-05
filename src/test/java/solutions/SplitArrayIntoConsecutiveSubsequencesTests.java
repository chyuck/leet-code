package solutions;

import org.junit.Assert;
import org.junit.Test;

public class SplitArrayIntoConsecutiveSubsequencesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SplitArrayIntoConsecutiveSubsequences();

        // act
        var result = solution.isPossible(new int[] { 1,2,3,3,4,5 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new SplitArrayIntoConsecutiveSubsequences();

        // act
        var result = solution.isPossible(new int[] { 1,2,3,3,4,4,5,5 });

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new SplitArrayIntoConsecutiveSubsequences();

        // act
        var result = solution.isPossible(new int[] { 1,2,3,4,4,5 });

        // assert
        Assert.assertFalse(result);
    }
}
