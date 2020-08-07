package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ExpressionAddOperatorsTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ExpressionAddOperators();

        // act
        var results = solution.addOperators("123", 6);

        // assert
        Assert.assertEquals(2, results.size());
        Assert.assertTrue(results.contains("1+2+3"));
        Assert.assertTrue(results.contains("1*2*3"));
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new ExpressionAddOperators();

        // act
        var results = solution.addOperators("232", 8);

        // assert
        Assert.assertEquals(2, results.size());
        Assert.assertTrue(results.contains("2*3+2"));
        Assert.assertTrue(results.contains("2+3*2"));
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new ExpressionAddOperators();

        // act
        var results = solution.addOperators("105", 5);

        // assert
        Assert.assertEquals(2, results.size());
        Assert.assertTrue(results.contains("1*0+5"));
        Assert.assertTrue(results.contains("10-5"));
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new ExpressionAddOperators();

        // act
        var results = solution.addOperators("00", 0);

        // assert
        Assert.assertEquals(3, results.size());
        Assert.assertTrue(results.contains("0+0"));
        Assert.assertTrue(results.contains("0-0"));
        Assert.assertTrue(results.contains("0*0"));
    }

    @Test
    public void testExample5(){
        // arrange
        var solution = new ExpressionAddOperators();

        // act
        var results = solution.addOperators("3456237490", 9191);

        // assert
        Assert.assertEquals(0, results.size());
    }
}
