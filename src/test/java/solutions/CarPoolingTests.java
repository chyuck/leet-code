package solutions;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarPoolingTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new CarPooling();

        // act
        var result = solution.carPooling(new int[][] { {2,1,5},{3,3,7} }, 4);

        // assert
        assertFalse(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new CarPooling();

        // act
        var result = solution.carPooling(new int[][] { {2,1,5},{3,3,7} }, 5);

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new CarPooling();

        // act
        var result = solution.carPooling(new int[][] { {2,1,5},{3,5,7} }, 3);

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new CarPooling();

        // act
        var result = solution.carPooling(new int[][] { {3,2,7},{3,7,9},{8,3,9} }, 11);

        // assert
        assertTrue(result);
    }
}
