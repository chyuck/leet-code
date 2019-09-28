package solutions;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class StringCompressionTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new StringCompression();

        var chars = new char[] { 'a','a','b','b','c','c','c' };

        // act
        var result = solution.compress(chars);

        // assert
        assertEquals(6, result);
        assertArrayEquals(new char[] { 'a','2','b','2','c','3' }, Arrays.copyOfRange(chars, 0, result));
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new StringCompression();

        var chars = new char[] { 'a' };

        // act
        var result = solution.compress(chars);

        // assert
        assertEquals(1, result);
        assertArrayEquals(new char[] { 'a' }, chars);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new StringCompression();

        var chars = new char[] { 'a','b','b','b','b','b','b','b','b','b','b','b','b' };

        // act
        var result = solution.compress(chars);

        // assert
        assertEquals(4, result);
        assertArrayEquals(new char[] { 'a','b','1','2' }, Arrays.copyOfRange(chars, 0, result));
    }
}
