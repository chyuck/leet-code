package solutions;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class RandomPickWithWeightTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new RandomPickWithWeight(new int[] { 1 });

        // act
        var result = solution.pickIndex();

        // assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void testExample2(){
        runAndAssert(new int[] { 1, 3 }, 10);
    }

    @Test
    public void testCase1(){
        runAndAssert(new int[] { 3, 14, 1, 7 }, 50);
    }

    private static void runAndAssert(int[] w, int times) {
        var solution = new RandomPickWithWeight(w);

        var results = new ArrayList<Integer>();

        for (int i = 0; i < times; i++) {
            var result = solution.pickIndex();
            Assert.assertTrue(0 <= result && result < w.length);
            results.add(result);
        }

        for (int i = 0; i < w.length; i++) {
            Assert.assertTrue(results.contains(i));
        }
    }
}
