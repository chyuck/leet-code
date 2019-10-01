package solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenerateParenthesesTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new GenerateParentheses();

        // act
        var results = solution.generateParenthesis(3);

        // assert
        assertEquals(List.of(
                "((()))",
                "(()())",
                "(())()",
                "()(())",
                "()()()"), results);
    }
}
