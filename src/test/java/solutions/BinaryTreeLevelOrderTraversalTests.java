package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BinaryTreeLevelOrderTraversalTests {

    @Test public void testExample() {
        // arrange
        var solution = new BinaryTreeLevelOrderTraversal();

        var tree = solution.new TreeNode(3,
                solution.new TreeNode(9),
                solution.new TreeNode(20,
                        solution.new TreeNode(15),
                        solution.new TreeNode(7)));

        // act
        var result = solution.levelOrder(tree);

        // assert
        assertEquals(3, result.size());

        assertEquals(List.of(3), result.get(0));
        assertEquals(List.of(9,20), result.get(1));
        assertEquals(List.of(15,7), result.get(2));
    }
}
