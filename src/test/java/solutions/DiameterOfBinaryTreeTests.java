package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class DiameterOfBinaryTreeTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new DiameterOfBinaryTree();

        var root = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)),
            new TreeNode(3));

        // act
        var result = solution.diameterOfBinaryTree(root);

        // assert
        Assert.assertEquals(3, result);
    }
}
