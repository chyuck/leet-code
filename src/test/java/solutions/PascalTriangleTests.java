package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PascalTriangleTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new PascalTriangle();

        // act
        var results = solution.generate(5);

        // assert
        assertEquals(5, results.size());
        assertArrayEquals(new Integer[] { 1 }, results.get(0).toArray(new Integer[1]));
        assertArrayEquals(new Integer[] { 1, 1 }, results.get(1).toArray(new Integer[2]));
        assertArrayEquals(new Integer[] { 1, 2, 1 }, results.get(2).toArray(new Integer[3]));
        assertArrayEquals(new Integer[] { 1, 3, 3, 1 }, results.get(3).toArray(new Integer[4]));
        assertArrayEquals(new Integer[] { 1, 4, 6, 4, 1 }, results.get(4).toArray(new Integer[5]));
    }
}
