package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagicSquaresInGridTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new MagicSquaresInGrid();

        // act
        var result = solution.numMagicSquaresInside(new int[][] {
                {4,3,8,4},
                {9,5,1,9},
                {2,7,6,2}});

        // assert
        assertEquals(1, result);
    }
}
