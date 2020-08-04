package solutions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class NestedListWeightSumTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new NestedListWeightSum();

        var list = Arrays.asList(
            new NestedListWeightSum.NestedInteger(Arrays.asList(
                new NestedListWeightSum.NestedInteger(1),
                new NestedListWeightSum.NestedInteger(1))),
            new NestedListWeightSum.NestedInteger(2),
            new NestedListWeightSum.NestedInteger(Arrays.asList(
                new NestedListWeightSum.NestedInteger(1),
                new NestedListWeightSum.NestedInteger(1))));

        // act
        var result = solution.depthSum(list);

        // assert
        Assert.assertEquals(10, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new NestedListWeightSum();

        var list = Arrays.asList(
            new NestedListWeightSum.NestedInteger(1),
            new NestedListWeightSum.NestedInteger(Arrays.asList(
                new NestedListWeightSum.NestedInteger(4),
                new NestedListWeightSum.NestedInteger(Arrays.asList(
                    new NestedListWeightSum.NestedInteger(6))))));

        // act
        var result = solution.depthSum(list);

        // assert
        Assert.assertEquals(27, result);
    }
}
