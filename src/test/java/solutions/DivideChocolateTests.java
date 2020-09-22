package solutions;

import org.junit.Assert;
import org.junit.Test;

public class DivideChocolateTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new DivideChocolate();

        // act
        var result = solution.maximizeSweetness(new int[] { 1,2,3,4,5,6,7,8,9 }, 5);

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new DivideChocolate();

        // act
        var result = solution.maximizeSweetness(new int[] { 5,6,7,8,9,1,2,3,4 }, 8);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new DivideChocolate();

        // act
        var result = solution.maximizeSweetness(new int[] { 1,2,2,1,2,2,1,2,2 }, 2);

        // assert
        Assert.assertEquals(5, result);
    }
}
