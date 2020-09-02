package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculator2Tests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BasicCalculator2();

        // act
        var result = solution.calculate("3+2*2");

        // assert
        Assert.assertEquals(7, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BasicCalculator2();

        // act
        var result = solution.calculate(" 3/2 ");

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new BasicCalculator2();

        // act
        var result = solution.calculate(" 3+5 / 2 ");

        // assert
        Assert.assertEquals(5, result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new BasicCalculator2();

        // act
        var result = solution.calculate("1-1+1");

        // assert
        Assert.assertEquals(1, result);
    }
}
