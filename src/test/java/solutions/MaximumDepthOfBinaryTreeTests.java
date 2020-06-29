package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.assertEquals;

public class MaximumDepthOfBinaryTreeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumDepthOfBinaryTree();

        var tree = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)));

        // act
        var result = solution.maxDepth(tree);

        // assert
        assertEquals(3, result);
    }
}
