package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProductOfArrayExceptSelfTests {

    @Test public void testExample() {
        // arrange
        var solution = new ProductOfArrayExceptSelf();

        // act
        var result = solution.productExceptSelf(new int[] { 1,2,3,4 });

        // assert
        assertArrayEquals(new int[] { 24,12,8,6 }, result);
    }
}
