package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class FirstUniqueCharacterInStringTests {

    @Test public void testExample1() {
        // arrange
        var solution = new FirstUniqueCharacterInString();

        // act
        var result = solution.firstUniqChar("leetcode");

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new FirstUniqueCharacterInString();

        // act
        var result = solution.firstUniqChar("loveleetcode");

        // assert
        assertEquals(2, result);
    }
}
