package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SqrtxTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new Sqrtx();

        // act
        var result = solution.mySqrt(4);

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new Sqrtx();

        // act
        var result = solution.mySqrt(8);

        // assert
        assertEquals(2, result);
    }
}
