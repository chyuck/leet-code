package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class MergeTwoBinaryTreesTests {

    @Test public void testExample() {
        // arrange
        var solution = new MergeTwoBinaryTrees();

        var tree1 = new TreeNode(1,
                new TreeNode(3,
                        new TreeNode(5),
                        null),
                new TreeNode(2));
        var tree2 = new TreeNode(2,
                new TreeNode(1,
                        null,
                        new TreeNode(4)),
                new TreeNode(3,
                        null,
                        new TreeNode(7)));

        // act
        var result = solution.mergeTrees(tree1, tree2);

        // assert
        assertEquals(3, result.val);

        assertEquals(4, result.left.val);
        assertEquals(5, result.right.val);

        assertEquals(5, result.left.left.val);
        assertEquals(4, result.left.right.val);
        assertNull(result.right.left);
        assertEquals(7, result.right.right.val);

        assertNull(result.left.left.left);
        assertNull(result.left.left.right);
        assertNull(result.left.right.left);
        assertNull(result.left.right.right);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}
