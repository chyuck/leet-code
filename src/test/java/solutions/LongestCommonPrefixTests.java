package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonPrefixTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new LongestCommonPrefix();

        // act
        var result = solution.longestCommonPrefix(new String[] { "flower","flow","flight" });

        // assert
        assertEquals("fl", result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new LongestCommonPrefix();

        // act
        var result = solution.longestCommonPrefix(new String[] { "dog","racecar","car" });

        // assert
        assertEquals("", result);
    }
}
