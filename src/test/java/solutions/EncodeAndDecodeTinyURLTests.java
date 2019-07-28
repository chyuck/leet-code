package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class EncodeAndDecodeTinyURLTests {

    @Test public void testExample() {
        // arrange
        final String url = "https://leetcode.com/problems/design-tinyurl";

        var solution = new EncodeAndDecodeTinyURL();

        // act
        var result = solution.decode(solution.encode(url));

        // assert
        assertEquals(url, result);
    }
}
