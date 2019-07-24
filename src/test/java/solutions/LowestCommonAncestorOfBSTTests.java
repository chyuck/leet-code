package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LowestCommonAncestorOfBSTTests {

    private static LowestCommonAncestorOfBST.TreeNode createTree(final LowestCommonAncestorOfBST solution) {
        return solution.new TreeNode(6,
                solution.new TreeNode(2,
                        solution.new TreeNode(0),
                        solution.new TreeNode(4,
                                solution.new TreeNode(3),
                                solution.new TreeNode(5))),
                solution.new TreeNode(8,
                        solution.new TreeNode(7),
                        solution.new TreeNode(9)));
    }

    @Test public void testExample1() {
        // arrange
        var solution = new LowestCommonAncestorOfBST();

        var root = createTree(solution);
        assert root.val == 6;

        var p = root.left;
        assert p.val == 2;
        var q = root.right;
        assert q.val == 8;

        // act
        var result = solution.lowestCommonAncestor(root, p, q);

        // assert
        assertEquals(root, result);
    }

    @Test public void testExample2() {
        // arrange
        var solution = new LowestCommonAncestorOfBST();

        var root = createTree(solution);

        var p = root.left;
        assert p.val == 2;
        var q = root.left.right;
        assert q.val == 4;

        // act
        var result = solution.lowestCommonAncestor(root, p, q);

        // assert
        assertEquals(p, result);
    }
}
