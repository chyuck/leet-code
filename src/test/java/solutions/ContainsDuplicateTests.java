package solutions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicateTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ContainsDuplicate();

        // act
        var result = solution.containsDuplicate(new int[] { 1,2,3,1 });

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new ContainsDuplicate();

        // act
        var result = solution.containsDuplicate(new int[] { 1,2,3,4 });

        // assert
        assertFalse(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new ContainsDuplicate();

        // act
        var result = solution.containsDuplicate(new int[] { 1,1,1,3,3,4,3,2,4,2 });

        // assert
        assertTrue(result);
    }
}
