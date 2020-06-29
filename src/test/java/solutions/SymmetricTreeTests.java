package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTreeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SymmetricTree();

        var tree = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(3),
                new TreeNode(4)),
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(3)));

        // act
        var result = solution.isSymmetric(tree);

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new SymmetricTree();

        var tree = new TreeNode(1,
            new TreeNode(2,
                null,
                new TreeNode(3)),
            new TreeNode(2,
                null,
                new TreeNode(3)));

        // act
        var result = solution.isSymmetric(tree);

        // assert
        assertFalse(result);
    }
}
