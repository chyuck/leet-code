package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LongestIncreasingPathInAMatrixTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new LongestIncreasingPathInAMatrix();

        var input = new int[][] {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };

        // act
        var result = solution.longestIncreasingPath(input);

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new LongestIncreasingPathInAMatrix();

        var input = new int[][] {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };

        // act
        var result = solution.longestIncreasingPath(input);

        // assert
        Assert.assertEquals(4, result);
    }
}
