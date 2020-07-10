package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ConvertANumberToHexadecimalTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ConvertANumberToHexadecimal();

        // act
        var result = solution.toHex(26);

        // assert
        Assert.assertEquals("1a", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new ConvertANumberToHexadecimal();

        // act
        var result = solution.toHex(-1);

        // assert
        Assert.assertEquals("ffffffff", result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new ConvertANumberToHexadecimal();

        // act
        var result = solution.toHex(Integer.MAX_VALUE);

        // assert
        Assert.assertEquals("7fffffff", result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new ConvertANumberToHexadecimal();

        // act
        var result = solution.toHex(Integer.MIN_VALUE);

        // assert
        Assert.assertEquals("80000000", result);
    }
}
