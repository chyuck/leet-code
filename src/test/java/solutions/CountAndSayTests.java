package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountAndSayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CountAndSay();

        // act
        var result = solution.countAndSay(1);

        // assert
        assertEquals("1", result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new CountAndSay();

        // act
        var result = solution.countAndSay(4);

        // assert
        assertEquals("1211", result);
    }
}
