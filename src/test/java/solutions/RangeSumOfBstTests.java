package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class RangeSumOfBstTests {

    @Test
    public void testExample1ForSolution1(){
        // arrange
        var solution = new RangeSumOfBst();

        var root = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3),
                new TreeNode(7)),
            new TreeNode(15,
                null,
                new TreeNode(18)));

        // act
        var result = solution.rangeSumBST(root, 7, 15);

        // assert
        Assert.assertEquals(32, result);
    }

    @Test
    public void testExample2ForSolution1(){
        // arrange
        var solution = new RangeSumOfBst();

        var root = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3,
                    new TreeNode(1),
                    null),
                new TreeNode(7,
                    new TreeNode(6),
                    null)),
            new TreeNode(15,
                new TreeNode(13),
                new TreeNode(18)));

        // act
        var result = solution.rangeSumBST(root, 6, 10);

        // assert
        Assert.assertEquals(23, result);
    }

    @Test
    public void testExample1ForSolution2(){
        // arrange
        var solution = new RangeSumOfBst();

        var root = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3),
                new TreeNode(7)),
            new TreeNode(15,
                null,
                new TreeNode(18)));

        // act
        var result = solution.rangeSumBST2(root, 7, 15);

        // assert
        Assert.assertEquals(32, result);
    }

    @Test
    public void testExample2ForSolution2(){
        // arrange
        var solution = new RangeSumOfBst();

        var root = new TreeNode(10,
            new TreeNode(5,
                new TreeNode(3,
                    new TreeNode(1),
                    null),
                new TreeNode(7,
                    new TreeNode(6),
                    null)),
            new TreeNode(15,
                new TreeNode(13),
                new TreeNode(18)));

        // act
        var result = solution.rangeSumBST2(root, 6, 10);

        // assert
        Assert.assertEquals(23, result);
    }
}
