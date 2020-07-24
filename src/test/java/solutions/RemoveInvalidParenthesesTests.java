package solutions;

import org.junit.Assert;
import org.junit.Test;

public class RemoveInvalidParenthesesTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new RemoveInvalidParentheses();

        // act
        var results = solution.removeInvalidParentheses("()())()");

        // assert
        Assert.assertArrayEquals(new Object[] { "()()()", "(())()" }, results.toArray());
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new RemoveInvalidParentheses();

        // act
        var results = solution.removeInvalidParentheses("(a)())()");

        // assert
        Assert.assertArrayEquals(new Object[] { "(a)()()", "(a())()" }, results.toArray());
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new RemoveInvalidParentheses();

        // act
        var results = solution.removeInvalidParentheses(")(");

        // assert
        Assert.assertArrayEquals(new Object[] { "" }, results.toArray());
    }
}
