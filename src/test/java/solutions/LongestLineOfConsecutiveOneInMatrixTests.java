package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LongestLineOfConsecutiveOneInMatrixTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new LongestLineOfConsecutiveOneInMatrix();

        // act
        var result = solution.longestLine(new int[][] {
            {0,1,1,0},
            {0,1,1,0},
            {0,0,0,1}
        });

        // assert
        Assert.assertEquals(3, result);
    }
}
