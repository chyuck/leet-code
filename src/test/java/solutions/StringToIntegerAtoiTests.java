package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringToIntegerAtoiTests {

    @Test public void testExample1() {
        // arrange
        var solution = new StringToIntegerAtoi();

        // act
        var result = solution.myAtoi("42");

        // assert
        assertEquals(42, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new StringToIntegerAtoi();

        // act
        var result = solution.myAtoi("   -42");

        // assert
        assertEquals(-42, result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new StringToIntegerAtoi();

        // act
        var result = solution.myAtoi("4193 with words");

        // assert
        assertEquals(4193, result);
    }

    @Test public void testExample4() {
        // arrange
        var solution = new StringToIntegerAtoi();

        // act
        var result = solution.myAtoi("words and 987");

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample5() {
        // arrange
        var solution = new StringToIntegerAtoi();

        // act
        var result = solution.myAtoi("-91283472332");

        // assert
        assertEquals(-2147483648, result);
    }
}
