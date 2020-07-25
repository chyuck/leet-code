package solutions;

import org.junit.Assert;
import org.junit.Test;

public class CustomSortStringTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new CustomSortString();

        // act
        var result = solution.customSortString("cba", "abcd");

        // assert
        Assert.assertEquals("cbad", result);
    }
}
