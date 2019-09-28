package solutions;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ValidPalindrome();

        // act
        var result = solution.isPalindrome("A man, a plan, a canal: Panama");

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ValidPalindrome();

        // act
        var result = solution.isPalindrome("race a car");

        // assert
        assertFalse(result);
    }
}
