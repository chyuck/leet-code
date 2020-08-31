package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculatorTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BasicCalculator();

        // act
        var result = solution.calculate("1 + 1");

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BasicCalculator();

        // act
        var result = solution.calculate(" 2-1 + 2 ");

        // assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new BasicCalculator();

        // act
        var result = solution.calculate("(1+(4+5+2)-3)+(6+8)");

        // assert
        Assert.assertEquals(23, result);
    }
}
