package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximalRectangleTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaximalRectangle();

        var matrix = new char[][] {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'}
        };

        // act
        var result = solution.maximalRectangle(matrix);

        // assert
        Assert.assertEquals(6, result);
    }
}
