package solutions;

import org.junit.Assert;
import org.junit.Test;

public class AddBinaryTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new AddBinary();

        // act
        var result = solution.addBinary("11", "1");

        // assert
        Assert.assertEquals("100", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new AddBinary();

        // act
        var result = solution.addBinary("1010", "1011");

        // assert
        Assert.assertEquals("10101", result);
    }
}
