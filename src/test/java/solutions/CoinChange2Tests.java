package solutions;

import org.junit.Assert;
import org.junit.Test;

public class CoinChange2Tests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new CoinChange2();

        // act
        var result = solution.change(5, new int[] { 1,2,5 });

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new CoinChange2();

        // act
        var result = solution.change(3, new int[] { 2 });

        // assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new CoinChange2();

        // act
        var result = solution.change(10, new int[] { 10 });

        // assert
        Assert.assertEquals(1, result);
    }
}
