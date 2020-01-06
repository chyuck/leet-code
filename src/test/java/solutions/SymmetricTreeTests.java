package solutions;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SymmetricTreeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new SymmetricTree();

        var tree = solution.new TreeNode(1,
            solution.new TreeNode(2,
                solution.new TreeNode(3),
                solution.new TreeNode(4)),
            solution.new TreeNode(2,
                solution.new TreeNode(4),
                solution.new TreeNode(3)));

        // act
        var result = solution.isSymmetric(tree);

        // assert
        assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new SymmetricTree();

        var tree = solution.new TreeNode(1,
            solution.new TreeNode(2,
                null,
                solution.new TreeNode(3)),
            solution.new TreeNode(2,
                null,
                solution.new TreeNode(3)));

        // act
        var result = solution.isSymmetric(tree);

        // assert
        assertFalse(result);
    }
}
