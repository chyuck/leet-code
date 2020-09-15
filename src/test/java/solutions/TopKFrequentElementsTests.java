package solutions;

import org.junit.Assert;
import org.junit.Test;

public class TopKFrequentElementsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new TopKFrequentElements();

        // act
        var result = solution.topKFrequent(new int[] { 1,1,1,2,2,3 }, 2);

        // assert
        Assert.assertArrayEquals(new int[] { 2, 1 }, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new TopKFrequentElements();

        // act
        var result = solution.topKFrequent(new int[] { 1 }, 1);

        // assert
        Assert.assertArrayEquals(new int[] { 1 }, result);
    }
}
