package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class RotateArrayTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new RotateArray();

        var nums = new int[] { 1,2,3,4,5,6,7 };

        // act
        solution.rotate(nums, 3);

        // assert
        assertArrayEquals(new int[] { 5,6,7,1,2,3,4 }, nums);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new RotateArray();

        var nums = new int[] { -1,-100,3,99 };

        // act
        solution.rotate(nums, 2);

        // assert
        assertArrayEquals(new int[] { 3,99,-1,-100 }, nums);
    }
}
