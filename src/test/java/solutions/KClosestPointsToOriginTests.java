package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class KClosestPointsToOriginTests {

    @Test
    public void testExample1() {
        // arrange
        final var points = new int[][] {{ 1, 3 }, { -2, 2 }};

        final var solution = new KClosestPointsToOrigin();

        // act
        final var result = solution.kClosest(points, 1);

        // assert
        assertArrayEquals(new int[][] {{ -2, 2 }}, result);
    }

    @Test
    public void testExample2() {
        // arrange
        final var points = new int[][] {{ 3, 3 }, { 5, -1 }, { -2, 4 }};

        final var solution = new KClosestPointsToOrigin();

        // act
        final var result = solution.kClosest(points, 2);

        // assert
        assertArrayEquals(new int[][] {{ -2, 4 }, { 3, 3 }}, result);
    }
}
