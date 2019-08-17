package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class ThreeSumTests {

    @Test public void testExample() {
        // arrange
        var solution = new ThreeSum();

        // act
        var results = solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });

        // assert
        assertEquals(2, results.size());
        assertTrue(results.contains(List.of(-1, 0, 1)));
        assertTrue(results.contains(List.of(-1, -1, 2)));
    }

    @Test public void testCase() {
        // arrange
        var solution = new ThreeSum();

        // act
        var results = solution.threeSum(new int[] { 0, 0, 0 });

        // assert
        assertEquals(1, results.size());
        assertEquals(List.of(0, 0, 0), results.get(0));
    }
}
