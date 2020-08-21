package solutions;

import org.junit.Assert;
import org.junit.Test;

public class CountOfSmallerNumbersAfterSelfTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CountOfSmallerNumbersAfterSelf();

        // act
        var result = solution.countSmaller(new int[] { 5,2,6,1 });

        // assert
        Assert.assertArrayEquals(new Integer[] { 2,1,1,0 }, result.toArray(new Integer[4]));
    }
}
