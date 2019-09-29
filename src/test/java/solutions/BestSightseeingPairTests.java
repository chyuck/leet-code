package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BestSightseeingPairTests {

    @Test
    public void testExample(){
        // arrange
        var solution = new BestSightseeingPair();

        // act
        var result = solution.maxScoreSightseeingPair(new int[] { 8,1,5,2,6 });

        // assert
        assertEquals(11, result);
    }
}
