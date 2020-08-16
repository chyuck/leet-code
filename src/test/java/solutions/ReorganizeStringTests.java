package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ReorganizeStringTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ReorganizeString();

        // act
        var result = solution.reorganizeString("aab");

        // assert
        Assert.assertEquals("aba", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new ReorganizeString();

        // act
        var result = solution.reorganizeString("aaab");

        // assert
        Assert.assertEquals("", result);
    }
}
