package solutions;

import org.junit.Assert;
import org.junit.Test;

public class SimplifyPathTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/home/");

        // assert
        Assert.assertEquals("/home", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/../");

        // assert
        Assert.assertEquals("/", result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/home//foo/");

        // assert
        Assert.assertEquals("/home/foo", result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/a/./b/../../c/");

        // assert
        Assert.assertEquals("/c", result);
    }

    @Test
    public void testExample5(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/a/../../b/../c//.//");

        // assert
        Assert.assertEquals("/c", result);
    }

    @Test
    public void testExample6(){
        // arrange
        var solution = new SimplifyPath();

        // act
        var result = solution.simplifyPath("/a//b////c/d//././/..");

        // assert
        Assert.assertEquals("/a/b/c", result);
    }
}
