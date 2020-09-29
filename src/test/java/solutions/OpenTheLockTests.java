package solutions;

import org.junit.Assert;
import org.junit.Test;

public class OpenTheLockTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new OpenTheLock();

        // act
        var result = solution.openLock(new String[] { "0201","0101","0102","1212","2002" }, "0202");

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new OpenTheLock();

        // act
        var result = solution.openLock(new String[] { "8888" }, "0009");

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new OpenTheLock();

        // act
        var result = solution.openLock(new String[] { "8887","8889","8878","8898","8788","8988","7888","9888" }, "8888");

        // assert
        Assert.assertEquals(-1, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new OpenTheLock();

        // act
        var result = solution.openLock(new String[] { "0000" }, "8888");

        // assert
        Assert.assertEquals(-1, result);
    }
}
