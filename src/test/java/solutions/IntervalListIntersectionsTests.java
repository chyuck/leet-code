package solutions;

import org.junit.Assert;
import org.junit.Test;

public class IntervalListIntersectionsTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new IntervalListIntersections();

        // act
        var result = solution.intervalIntersection(
            new int[][] { {0,2}, {5,10}, {13,23}, {24,25}},
            new int[][] { {1,5}, {8,12}, {15,24}, {25,26} });

        // assert
        Assert.assertArrayEquals(new int[][] { {1,2}, {5,5}, {8,10}, {15,23}, {24,24}, {25,25} }, result);
    }
}
