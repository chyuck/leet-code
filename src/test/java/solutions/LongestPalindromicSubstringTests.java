package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestPalindromicSubstringTests {

    @Test public void testExample1ForSolution1() {
        // arrange
        final var solution = new LongestPalindromicSubstring();

        // act
        final var result = solution.longestPalindrome("babad");

        // assert
        assertEquals("bab", result);
    }

    @Test public void testExample2ForSolution1() {
        // arrange
        final var solution = new LongestPalindromicSubstring();

        // act
        final var result = solution.longestPalindrome("cbbd");

        // assert
        assertEquals("bb", result);
    }

    @Test public void testExample1ForSolution2() {
        // arrange
        final var solution = new LongestPalindromicSubstring();

        // act
        final var result = solution.longestPalindrome2("babad");

        // assert
        assertEquals("bab", result);
    }

    @Test public void testExample2ForSolution2() {
        // arrange
        final var solution = new LongestPalindromicSubstring();

        // act
        final var result = solution.longestPalindrome2("cbbd");

        // assert
        assertEquals("bb", result);
    }
}
