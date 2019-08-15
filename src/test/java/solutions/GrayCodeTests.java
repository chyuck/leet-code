package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class GrayCodeTests {

    @Test public void testExample1() {
        // arrange
        var solution = new GrayCode();

        // act
        var results = solution.grayCode(2);

        // assert
        assertEquals(List.of(0,1,3,2), results);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new GrayCode();

        // act
        var results = solution.grayCode(0);

        // assert
        assertEquals(List.of(0), results);
    }
}
