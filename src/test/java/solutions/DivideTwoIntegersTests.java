package solutions;

import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegersTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(10, 3);

        // assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(7, -3);

        // assert
        Assert.assertEquals(-2, result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(Integer.MIN_VALUE, -1);

        // assert
        Assert.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testCase2() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(Integer.MAX_VALUE, 1);

        // assert
        Assert.assertEquals(Integer.MAX_VALUE, result);
    }

    @Test
    public void testCase3() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(Integer.MIN_VALUE, 1);

        // assert
        Assert.assertEquals(Integer.MIN_VALUE, result);
    }

    @Test
    public void testCase4() {
        // arrange
        var solution = new DivideTwoIntegers();

        // act
        var result = solution.divide(Integer.MIN_VALUE, 2);

        // assert
        Assert.assertEquals(Integer.MIN_VALUE / 2, result);
    }
}
