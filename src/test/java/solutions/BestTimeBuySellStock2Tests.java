package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestTimeBuySellStock2Tests {

    @Test
    public void testExample1(){
        // arrange
        final var solution = new BestTimeBuySellStock2();

        // act
        final var result = solution.maxProfit(new int[] { 7,1,5,3,6,4 });

        // assert
        assertEquals(7, result);
    }

    @Test
    public void testExample2(){
        // arrange
        final var solution = new BestTimeBuySellStock2();

        // act
        final var result = solution.maxProfit(new int[] { 1,2,3,4,5 });

        // assert
        assertEquals(4, result);
    }

    @Test
    public void testExample3(){
        // arrange
        final var solution = new BestTimeBuySellStock2();

        // act
        final var result = solution.maxProfit(new int[] { 7,6,4,3,1 });

        // assert
        assertEquals(0, result);
    }
}
