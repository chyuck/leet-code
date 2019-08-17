package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestSubstringWithoutRepeatingCharactersTests {

    @Test public void testExample1() {
        // arrange
        var solution = new LongestSubstringWithoutRepeatingCharacters();

        // act
        var result = solution.lengthOfLongestSubstring("abcabcbb");

        // assert
        assertEquals(3, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new LongestSubstringWithoutRepeatingCharacters();

        // act
        var result = solution.lengthOfLongestSubstring("bbbbb");

        // assert
        assertEquals(1, result);
    }

    @Test public void testExample3() {
        // arrange
        var solution = new LongestSubstringWithoutRepeatingCharacters();

        // act
        var result = solution.lengthOfLongestSubstring("pwwkew");

        // assert
        assertEquals(3, result);
    }
}
