package solutions;

import org.junit.Assert;
import org.junit.Test;

public class MinimumRemoveToMakeValidParenthesesTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MinimumRemoveToMakeValidParentheses();

        // act
        var result = solution.minRemoveToMakeValid("lee(t(c)o)de)");

        // assert
        Assert.assertEquals("lee(t(c)o)de", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new MinimumRemoveToMakeValidParentheses();

        // act
        var result = solution.minRemoveToMakeValid("a)b(c)d");

        // assert
        Assert.assertEquals("ab(c)d", result);
    }

    @Test
    public void testExample13(){
        // arrange
        var solution = new MinimumRemoveToMakeValidParentheses();

        // act
        var result = solution.minRemoveToMakeValid("))((");

        // assert
        Assert.assertEquals("", result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new MinimumRemoveToMakeValidParentheses();

        // act
        var result = solution.minRemoveToMakeValid("(a(b(c)d)");

        // assert
        Assert.assertEquals("a(b(c)d)", result);
    }
}
