package solutions;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ValidPalindrome2Tests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ValidPalindrome2();

        // act
        var result = solution.validPalindrome("aba");

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ValidPalindrome2();

        // act
        var result = solution.validPalindrome("abca");

        // assert
        assertTrue(result);
    }

    @Test
    public void testCase1() {
        // arrange
        var solution = new ValidPalindrome2();

        // act
        var result = solution.validPalindrome("ebcbbececabbacecbbcbe");

        // assert
        assertTrue(result);
    }
}
