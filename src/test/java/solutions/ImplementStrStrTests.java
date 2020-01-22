package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementStrStrTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ImplementStrStr();

        // act
        var result = solution.strStr("hello", "ll");

        // assert
        assertEquals(2, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ImplementStrStr();

        // act
        var result = solution.strStr("aaaaa", "bba");

        // assert
        assertEquals(-1, result);
    }
}
