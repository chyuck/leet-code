package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MinimumKnightMovesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MinimumKnightMoves();

        // act
        var result = solution.minKnightMoves(2, 1);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new MinimumKnightMoves();

        // act
        var result = solution.minKnightMoves(5, 5);

        // assert
        Assert.assertEquals(4, result);
    }
}
