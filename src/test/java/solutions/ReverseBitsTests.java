package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBitsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ReverseBits();

        // act
        var result = solution.reverseBits(0b00000010100101000001111010011100);

        // assert
        assertEquals(0b00111001011110000010100101000000, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ReverseBits();

        // act
        var result = solution.reverseBits(0b11111111111111111111111111111101);

        // assert
        assertEquals(0b10111111111111111111111111111111, result);
    }
}
