package solutions;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersionTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new FirstBadVersion(4);

        // act
        var result = solution.firstBadVersion(5);

        // assert
        Assert.assertEquals(4, result);
    }
}
