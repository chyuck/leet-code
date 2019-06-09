package solutions;

import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTreeZigzagTraversalTests {

    @Test public void testExample() {
        // arrange
        final var solution = new BinaryTreeZigzagTraversal();

        final var tree = solution.new TreeNode(3,
            solution.new TreeNode(9),
            solution.new TreeNode(20,
                solution.new TreeNode(15),
                solution.new TreeNode(7)));

        // act
        final var result = solution.zigzagLevelOrder(tree);

        // assert
        assertEquals(3, result.size());

        assertEquals(1, result.get(0).size());
        assertEquals(3, (int) result.get(0).get(0));

        assertEquals(2, result.get(1).size());
        assertEquals(20, (int) result.get(1).get(0));
        assertEquals(9, (int) result.get(1).get(1));

        assertEquals(2, result.get(2).size());
        assertEquals(15, (int) result.get(2).get(0));
        assertEquals(7, (int) result.get(2).get(1));
    }
}
