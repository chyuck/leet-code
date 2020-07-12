package solutions;

import org.junit.Assert;
import org.junit.Test;

public class PowxNTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new PowxN();

        // act
        var result = solution.myPow(2.0, 10);

        // assert
        Assert.assertEquals(1024.0, result, 0.00001);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new PowxN();

        // act
        var result = solution.myPow(2.1, 3);

        // assert
        Assert.assertEquals(9.261, result, 0.00001);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new PowxN();

        // act
        var result = solution.myPow(2.0, -2);

        // assert
        Assert.assertEquals(0.25, result, 0.00001);
    }
}
