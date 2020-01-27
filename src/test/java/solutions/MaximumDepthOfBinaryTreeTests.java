package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaximumDepthOfBinaryTreeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new MaximumDepthOfBinaryTree();

        var tree = solution.new TreeNode(3,
            solution.new TreeNode(9),
            solution.new TreeNode(20,
                solution.new TreeNode(15),
                solution.new TreeNode(7)));

        // act
        var result = solution.maxDepth(tree);

        // assert
        assertEquals(3, result);
    }
}
