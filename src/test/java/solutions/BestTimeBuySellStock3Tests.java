package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeBuySellStock3Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new BestTimeBuySellStock3();

        // act
        var result = solution.maxProfit(new int[] { 3,3,5,0,0,3,1,4 });

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new BestTimeBuySellStock3();

        // act
        var result = solution.maxProfit(new int[] { 1,2,3,4,5 });

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new BestTimeBuySellStock3();

        // act
        var result = solution.maxProfit(new int[] { 7,6,4,3,1 });

        // assert
        Assert.assertEquals(0, result);
    }
}
