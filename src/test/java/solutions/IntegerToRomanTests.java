package solutions;

import org.junit.Assert;
import org.junit.Test;

public class IntegerToRomanTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new IntegerToRoman();

        // act
        var result = solution.intToRoman(3);

        // assert
        Assert.assertEquals("III", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new IntegerToRoman();

        // act
        var result = solution.intToRoman(4);

        // assert
        Assert.assertEquals("IV", result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new IntegerToRoman();

        // act
        var result = solution.intToRoman(9);

        // assert
        Assert.assertEquals("IX", result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new IntegerToRoman();

        // act
        var result = solution.intToRoman(58);

        // assert
        Assert.assertEquals("LVIII", result);
    }

    @Test
    public void testExample5(){
        // arrange
        var solution = new IntegerToRoman();

        // act
        var result = solution.intToRoman(1994);

        // assert
        Assert.assertEquals("MCMXCIV", result);
    }
}
