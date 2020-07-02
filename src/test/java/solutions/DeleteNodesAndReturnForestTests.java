package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class DeleteNodesAndReturnForestTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new DeleteNodesAndReturnForest();

        TreeNode root = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode( 5)),
            new TreeNode(3,
                new TreeNode(6),
                new TreeNode( 7)));

        // act
        var results = solution.delNodes(root, new int[] { 3,5 });

        // assert
        Assert.assertEquals(3, results.size());

        var result1 = results.get(0);
        Assert.assertEquals(1, result1.val);
        Assert.assertEquals(2, result1.left.val);
        Assert.assertNull(result1.right);
        Assert.assertEquals(4, result1.left.left.val);
        Assert.assertNull(result1.left.right);

        var result2 = results.get(1);
        Assert.assertEquals(6, result2.val);
        Assert.assertNull(result2.left);
        Assert.assertNull(result2.right);

        var result3 = results.get(2);
        Assert.assertEquals(7, result3.val);
        Assert.assertNull(result3.left);
        Assert.assertNull(result3.right);
    }
}
