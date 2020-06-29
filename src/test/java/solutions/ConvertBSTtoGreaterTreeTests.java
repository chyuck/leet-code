package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class ConvertBSTtoGreaterTreeTests {

    @Test public void testExample() {
        // arrange
        var solution = new ConvertBSTtoGreaterTree();

        var tree = new TreeNode(5,
                new TreeNode(2),
                new TreeNode(13));

        // act
        var result = solution.convertBST(tree);

        // assert
        assertEquals(18, result.val);

        assertEquals(20, result.left.val);
        assertEquals(13, result.right.val);

        assertNull(result.left.left);
        assertNull(result.left.right);
        assertNull(result.right.left);
        assertNull(result.right.right);
    }
}
