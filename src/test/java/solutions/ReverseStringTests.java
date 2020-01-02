package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ReverseStringTests {

    @Test
    public void testExample1() {
        // arrange
        var str = new char[] { 'h','e','l','l','o' };

        var solution = new ReverseString();

        // act
        solution.reverseString(str);

        // assert
        assertArrayEquals(new char[] { 'o','l','l','e','h' }, str);
    }

    @Test
    public void testExample2() {
        // arrange
        var str = new char[] { 'H','a','n','n','a','h' };

        var solution = new ReverseString();

        // act
        solution.reverseString(str);

        // assert
        assertArrayEquals(new char[] { 'h','a','n','n','a','H' }, str);
    }
}
