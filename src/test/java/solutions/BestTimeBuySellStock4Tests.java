package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeBuySellStock4Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new BestTimeBuySellStock4();

        // act
        var result = solution.maxProfit(2, new int[] { 2,4,1 });

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new BestTimeBuySellStock4();

        // act
        var result = solution.maxProfit(2, new int[] { 3,2,6,5,0,3 });

        // assert
        Assert.assertEquals(7, result);
    }
}
