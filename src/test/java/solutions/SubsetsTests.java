package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class SubsetsTests {

    @Test public void testExample() {
        // arrange
        var solution = new Subsets();

        // act
        var results = solution.subsets(new int[] { 1,2,3 });

        // assert
        assertEquals(8, results.size());
        assertTrue(results.contains(List.of()));
        assertTrue(results.contains(List.of(1)));
        assertTrue(results.contains(List.of(2)));
        assertTrue(results.contains(List.of(3)));
        assertTrue(results.contains(List.of(1,2)));
        assertTrue(results.contains(List.of(1,3)));
        assertTrue(results.contains(List.of(2,3)));
        assertTrue(results.contains(List.of(1,2,3)));
    }
}
