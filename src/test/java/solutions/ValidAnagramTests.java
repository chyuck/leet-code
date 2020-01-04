package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidAnagramTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ValidAnagram();

        // act
        var result = solution.isAnagram("anagram", "nagaram");

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ValidAnagram();

        // act
        var result = solution.isAnagram("rat", "car");

        // assert
        assertFalse(result);
    }
}