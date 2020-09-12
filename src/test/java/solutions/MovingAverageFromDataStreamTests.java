package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MovingAverageFromDataStreamTests {

    @Test
    public void testExample1() {
        var solution = new MovingAverageFromDataStream(3);

        Assert.assertEquals(1.0, solution.next(1), 0.01);
        Assert.assertEquals((1 + 10) / 2.0, solution.next(10), 0.01);
        Assert.assertEquals((1 + 10 + 3) / 3.0, solution.next(3), 0.01);
        Assert.assertEquals((10 + 3 + 5) / 3.0, solution.next(5), 0.01);
    }
}
