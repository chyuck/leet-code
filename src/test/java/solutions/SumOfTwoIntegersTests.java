package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfTwoIntegersTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SumOfTwoIntegers();

        // act
        var result = solution.getSum(1, 2);

        // assert
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new SumOfTwoIntegers();

        // act
        var result = solution.getSum(-2, 3);

        // assert
        assertEquals(1, result);
    }
}
