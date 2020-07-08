package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class BinaryTreePathsTests {

    @Test
    public void testExample1(){
        // arrange
        TreeNode root = new TreeNode(1,
            new TreeNode(2,
                null,
                new TreeNode(5)),
            new TreeNode(3));

        var solution = new BinaryTreePaths();

        // act
        var results = solution.binaryTreePaths(root);

        // assert
        Assert.assertEquals(2, results.size());
        Assert.assertEquals("1->2->5", results.get(0));
        Assert.assertEquals("1->3", results.get(1));
    }
}
