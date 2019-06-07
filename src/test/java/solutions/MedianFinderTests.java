package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class MedianFinderTests {

    @Test public void testExample() {
        final var solution = new MedianFinder();

        solution.addNum(1);
        solution.addNum(2);
        assertEquals(1.5, solution.findMedian(), 0.01);
        solution.addNum(3);
        assertEquals(2.0, solution.findMedian(), 0.01);
    }
}
