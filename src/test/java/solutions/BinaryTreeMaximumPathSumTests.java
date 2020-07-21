package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class BinaryTreeMaximumPathSumTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new BinaryTreeMaximumPathSum();

        var root = new TreeNode(1,
            new TreeNode(2),
            new TreeNode(3));

        // act
        var result = solution.maxPathSum(root);

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new BinaryTreeMaximumPathSum();

        var root = new TreeNode(-10,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)));

        // act
        var result = solution.maxPathSum(root);

        // assert
        Assert.assertEquals(42, result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new BinaryTreeMaximumPathSum();

        var root = new TreeNode(2,
            new TreeNode(-1),
            null);

        // act
        var result = solution.maxPathSum(root);

        // assert
        Assert.assertEquals(2, result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new BinaryTreeMaximumPathSum();

        var root = new TreeNode(1,
            new TreeNode(-2),
            new TreeNode(3));

        // act
        var result = solution.maxPathSum(root);

        // assert
        Assert.assertEquals(4, result);
    }
}
