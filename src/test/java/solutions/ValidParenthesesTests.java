package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidParenthesesTests {

    @Test
    public void testExample1() {
        // arrange
        final var solution = new ValidParentheses();

        // act
        final var result = solution.isValid("()");

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        final var solution = new ValidParentheses();

        // act
        final var result = solution.isValid("()[]{}");

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        final var solution = new ValidParentheses();

        // act
        final var result = solution.isValid("(]");

        // assert
        assertFalse(result);
    }

    @Test
    public void testExample4() {
        // arrange
        final var solution = new ValidParentheses();

        // act
        final var result = solution.isValid("([)]");

        // assert
        assertFalse(result);
    }

    @Test
    public void testExample5() {
        // arrange
        final var solution = new ValidParentheses();

        // act
        final var result = solution.isValid("{[]}");

        // assert
        assertTrue(result);
    }
}
