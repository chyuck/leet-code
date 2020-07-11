package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CoinChangeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CoinChange();

        // act
        var result = solution.coinChange(new int[] { 1, 2, 5 }, 11);

        // assert
        assertEquals(3, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new CoinChange();

        // act
        var result = solution.coinChange(new int[] { 2 }, 3);

        // assert
        assertEquals(-1, result);
    }
}
