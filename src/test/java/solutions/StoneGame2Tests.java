package solutions;

import org.junit.Assert;
import org.junit.Test;

public class StoneGame2Tests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new StoneGame2();

        // act
        var result = solution.stoneGameII(new int[] { 2,7,9,4,4 });

        // assert
        Assert.assertEquals(10, result);
    }
}
