package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RomanToIntegerTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new RomanToInteger();

        // act
        var result = solution.romanToInt("III");

        // assert
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new RomanToInteger();

        // act
        var result = solution.romanToInt("IV");

        // assert
        assertEquals(4, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new RomanToInteger();

        // act
        var result = solution.romanToInt("IX");

        // assert
        assertEquals(9, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new RomanToInteger();

        // act
        var result = solution.romanToInt("LVIII");

        // assert
        assertEquals(58, result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new RomanToInteger();

        // act
        var result = solution.romanToInt("MCMXCIV");

        // assert
        assertEquals(1994, result);
    }
}
