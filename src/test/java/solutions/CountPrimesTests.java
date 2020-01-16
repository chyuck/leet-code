package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class CountPrimesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CountPrimes();

        // act
        var result = solution.countPrimes(10);

        // assert
        assertEquals(4, result);
    }
}
