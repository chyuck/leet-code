package solutions;

import org.junit.Assert;
import org.junit.Test;

public class RLEIteratorTests {

    @Test
    public void testExample1() {
        var solution = new RLEIterator(new int[] { 3,8,0,9,2,5 });

        Assert.assertEquals(8, solution.next(2));
        Assert.assertEquals(8, solution.next(1));
        Assert.assertEquals(5, solution.next(1));
        Assert.assertEquals(-1, solution.next(2));
    }
}
