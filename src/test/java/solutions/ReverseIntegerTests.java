package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseIntegerTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ReverseInteger();

        // act
        var result = solution.reverse(123);

        // assert
        assertEquals(321, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new ReverseInteger();

        // act
        var result = solution.reverse(-123);

        // assert
        assertEquals(-321, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new ReverseInteger();

        // act
        var result = solution.reverse(120);

        // assert
        assertEquals(21, result);
    }
}