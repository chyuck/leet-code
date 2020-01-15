package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class BestTimeBuySellStockTests {

    @Test public void testExample1(){
        // arrange
        final var solution = new BestTimeBuySellStock();

        // act
        final var result = solution.maxProfit(new int[] { 7,1,5,3,6,4 });

        // assert
        assertEquals(5, result);
    }

    @Test public void testExample2(){
        // arrange
        final var solution = new BestTimeBuySellStock();

        // act
        final var result = solution.maxProfit(new int[] { 7,6,4,3,1 });

        // assert
        assertEquals(0, result);
    }
}
