package solutions;

import org.junit.Assert;
import org.junit.Test;

public class IsGraphBipartiteTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new IsGraphBipartite();

        var graph = new int[][] { {1, 3}, {0, 2}, {1, 3}, {0, 2} };

        // act
        var result = solution.isBipartite(graph);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new IsGraphBipartite();

        var graph = new int[][] { {1, 2, 3}, {0, 2}, {0, 1, 3}, {0, 2} };

        // act
        var result = solution.isBipartite(graph);

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new IsGraphBipartite();

        var graph = new int[][] { {} };

        // act
        var result = solution.isBipartite(graph);

        // assert
        Assert.assertTrue(result);
    }
}
