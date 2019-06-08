package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class LowestCommonAncestorTests {

    private static LowestCommonAncestor.TreeNode createTree(final LowestCommonAncestor solution) {
        return solution.new TreeNode(3,
            solution.new TreeNode(5,
                solution.new TreeNode(6),
                solution.new TreeNode(2,
                    solution.new TreeNode(7),
                    solution.new TreeNode(4))),
            solution.new TreeNode(1,
                solution.new TreeNode(0),
                solution.new TreeNode(8)));
    }

    @Test public void testExample1ForSolution1() {
        // arrange
        final var solution = new LowestCommonAncestor();

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

    @Test public void testExample2ForSolution1() {
        // arrange
        final var solution = new LowestCommonAncestor();

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

    @Test public void testExample1ForSolution2() {
        // arrange
        final var solution = new LowestCommonAncestor();

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

    @Test public void testExample2ForSolution2() {
        // arrange
        final var solution = new LowestCommonAncestor();

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
