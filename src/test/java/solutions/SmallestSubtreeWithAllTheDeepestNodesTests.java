package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodesTests {

    @Test
    public void testExample1(){
        // arrange
        TreeNode root = new TreeNode(3,
            new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                    new TreeNode(7),
                    new TreeNode(4))),
            new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8)));

        var solution = new SmallestSubtreeWithAllTheDeepestNodes();

        // act
        var result = solution.subtreeWithAllDeepest(root);

        // assert
        Assert.assertEquals(2, result.val);
        Assert.assertEquals(7, result.left.val);
        Assert.assertNull(result.left.left);
        Assert.assertNull(result.left.right);
        Assert.assertEquals(4, result.right.val);
        Assert.assertNull(result.right.left);
        Assert.assertNull(result.right.right);
    }
}