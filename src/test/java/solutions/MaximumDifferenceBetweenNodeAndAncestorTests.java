package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestorTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new MaximumDifferenceBetweenNodeAndAncestor();

        TreeNode root = new TreeNode(8,
            new TreeNode(3,
                new TreeNode(1),
                new TreeNode(6,
                    new TreeNode(4),
                    new TreeNode(7))),
            new TreeNode(10,
                null,
                new TreeNode(14,
                    new TreeNode(13),
                    null)));

        // act
        var result = solution.maxAncestorDiff(root);

        // assert
        Assert.assertEquals(7, result);
    }
}
