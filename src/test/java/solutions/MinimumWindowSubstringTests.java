package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumWindowSubstringTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new MinimumWindowSubstring();

        // act
        var result = solution.minWindow("ADOBECODEBANC", "ABC");

        // assert
        assertEquals("BANC", result);
    }
}
