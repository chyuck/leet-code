package solutions;

import org.junit.Assert;
import org.junit.Test;

public class HandOfStraightsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new HandOfStraights();

        // act
        var result = solution.isNStraightHand(new int[] { 1,2,3,6,2,3,4,7,8 }, 3);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new HandOfStraights();

        // act
        var result = solution.isNStraightHand(new int[] { 1,2,3,4,5 }, 4);

        // assert
        Assert.assertFalse(result);
    }
}
