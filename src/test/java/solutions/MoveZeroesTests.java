package solutions;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MoveZeroesTests {

    @Test
    public void testExample() {
        // arrange
        var nums = new int[] { 0,1,0,3,12 };

        var solution = new MoveZeroes();

        // act
        solution.moveZeroes(nums);

        // assert
        assertArrayEquals(new int[] { 1,3,12,0,0 }, nums);
    }
}
