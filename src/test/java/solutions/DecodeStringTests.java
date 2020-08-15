package solutions;

import org.junit.Assert;
import org.junit.Test;

public class DecodeStringTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new DecodeString();

        // act
        var result = solution.decodeString("3[a]2[bc]");

        // assert
        Assert.assertEquals("aaabcbc", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new DecodeString();

        // act
        var result = solution.decodeString("3[a2[c]]");

        // assert
        Assert.assertEquals("accaccacc", result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new DecodeString();

        // act
        var result = solution.decodeString("2[abc]3[cd]ef");

        // assert
        Assert.assertEquals("abcabccdcdcdef", result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new DecodeString();

        // act
        var result = solution.decodeString("abc3[cd]xyz");

        // assert
        Assert.assertEquals("abccdcdcdxyz", result);
    }
}
