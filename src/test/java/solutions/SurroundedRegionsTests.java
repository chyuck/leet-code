package solutions;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;


public class SurroundedRegionsTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SurroundedRegions();

        var board = new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};

        // act
        solution.solve(board);

        // assert
        assertArrayEquals(new char[][] {
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        }, board);
    }
}
