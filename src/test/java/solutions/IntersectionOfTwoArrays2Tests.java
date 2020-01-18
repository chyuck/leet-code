package solutions;

import java.util.Arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArrays2Tests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new IntersectionOfTwoArrays2();

        // act
        var result = solution.intersect(new int[] { 1,2,2,1 }, new int[] { 2,2 });

        // assert
        assertArrayEquals(new int[] { 2,2 }, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new IntersectionOfTwoArrays2();

        // act
        var result = solution.intersect(new int[] { 4,9,5 }, new int[] { 9,4,9,8,4 });

        // assert
        Arrays.sort(result);

        assertArrayEquals(new int[] { 4,9 }, result);
    }
}
