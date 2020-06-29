package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfBSTTests {

    private static TreeNode createTree(final LowestCommonAncestorOfBST solution) {
        return new TreeNode(6,
                new TreeNode(2,
                        new TreeNode(0),
                        new TreeNode(4,
                                new TreeNode(3),
                                new TreeNode(5))),
                new TreeNode(8,
                        new TreeNode(7),
                        new TreeNode(9)));
    }

    @Test
    public void testExample1() {
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

    @Test
    public void testExample2() {
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
