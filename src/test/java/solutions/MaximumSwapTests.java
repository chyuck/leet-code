package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSwapTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaximumSwap();

        // act
        var result = solution.maximumSwap(2736);

        // assert
        Assert.assertEquals(7236, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new MaximumSwap();

        // act
        var result = solution.maximumSwap(9973);

        // assert
        Assert.assertEquals(9973, result);
    }
}
