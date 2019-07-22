package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class PascalTriangle2Tests {

    @Test public void testExample1() {
        // arrange
        var solution = new PascalTriangle2();

        // act
        var result = solution.getRow(3);

        // assert
        assertEquals(List.of(1,3,3,1), result);
    }
}
