package solutions;

import org.junit.Assert;
import org.junit.Test;

public class BasicCalculator3Tests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BasicCalculator3();

        // act
        var result = solution.calculate("1 + 1");

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BasicCalculator3();

        // act
        var result = solution.calculate(" 6-4 / 2 ");

        // assert
        Assert.assertEquals(4, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new BasicCalculator3();

        // act
        var result = solution.calculate("2*(5+5*2)/3+(6/2+8)");

        // assert
        Assert.assertEquals(21, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new BasicCalculator3();

        // act
        var result = solution.calculate("(2+6* 3+5- (3*14/7+2)*5)+3");

        // assert
        Assert.assertEquals(-12, result);
    }
}
