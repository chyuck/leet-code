package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContainerWithMostWaterTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new ContainerWithMostWater();

        // act
        var result = solution.maxArea(new int[] { 1,8,6,2,5,4,8,3,7 });

        // assert
        assertEquals(49, result);
    }
}
