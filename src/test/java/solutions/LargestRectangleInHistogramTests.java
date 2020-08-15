package solutions;

import org.junit.Assert;
import org.junit.Test;

public class LargestRectangleInHistogramTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new LargestRectangleInHistogram();

        // act
        var result = solution.largestRectangleArea(new int[] { 2,1,5,6,2,3 });

        // assert
        Assert.assertEquals(10, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new LargestRectangleInHistogram();

        // act
        var result = solution.largestRectangleArea(new int[] { 2,1,2 });

        // assert
        Assert.assertEquals(3, result);
    }
}
