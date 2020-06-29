package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfBTTests {

    private static TreeNode createTree(final LowestCommonAncestorOfBT solution) {
        return new TreeNode(3,
            new TreeNode(5,
                new TreeNode(6),
                new TreeNode(2,
                    new TreeNode(7),
                    new TreeNode(4))),
            new TreeNode(1,
                new TreeNode(0),
                new TreeNode(8)));
    }

    @Test
    public void testExample1ForSolution1() {
        // arrange
        final var solution = new LowestCommonAncestorOfBT();

        final var root = createTree(solution);
        assert root.val == 3;

        final var p = root.left;
        assert p.val == 5;
        final var q = root.right;
        assert q.val == 1;

        // act
        final var result = solution.lowestCommonAncestor(root, p, q);

        // assert
        assertEquals(root, result);
    }

    @Test
    public void testExample2ForSolution1() {
        // arrange
        final var solution = new LowestCommonAncestorOfBT();

        final var root = createTree(solution);

        final var p = root.left;
        assert p.val == 5;
        final var q = p.right.right;
        assert q.val == 4;

        // act
        final var result = solution.lowestCommonAncestor(root, p, q);

        // assert
        assertEquals(p, result);
    }

    @Test
    public void testExample1ForSolution2() {
        // arrange
        final var solution = new LowestCommonAncestorOfBT();

        final var root = createTree(solution);
        assert root.val == 3;

        final var p = root.left;
        assert p.val == 5;
        final var q = root.right;
        assert q.val == 1;

        // act
        final var result = solution.lowestCommonAncestor2(root, p, q);

        // assert
        assertEquals(root, result);
    }

    @Test
    public void testExample2ForSolution2() {
        // arrange
        final var solution = new LowestCommonAncestorOfBT();

        final var root = createTree(solution);

        final var p = root.left;
        assert p.val == 5;
        final var q = p.right.right;
        assert q.val == 4;

        // act
        final var result = solution.lowestCommonAncestor2(root, p, q);

        // assert
        assertEquals(p, result);
    }
}
