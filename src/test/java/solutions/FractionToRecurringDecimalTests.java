package solutions;

import org.junit.Assert;
import org.junit.Test;

public class FractionToRecurringDecimalTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new FractionToRecurringDecimal();

        // act
        var result = solution.fractionToDecimal(1, 2);

        // assert
        Assert.assertEquals("0.5", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new FractionToRecurringDecimal();

        // act
        var result = solution.fractionToDecimal(2, 1);

        // assert
        Assert.assertEquals("2", result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new FractionToRecurringDecimal();

        // act
        var result = solution.fractionToDecimal(2, 3);

        // assert
        Assert.assertEquals("0.(6)", result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new FractionToRecurringDecimal();

        // act
        var result = solution.fractionToDecimal(4, 333);

        // assert
        Assert.assertEquals("0.(012)", result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new FractionToRecurringDecimal();

        // act
        var result = solution.fractionToDecimal(-1, Integer.MIN_VALUE);

        // assert
        Assert.assertEquals("0.0000000004656612873077392578125", result);
    }
}
