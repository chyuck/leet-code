package solutions;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTests {

    @Test public void testExample() {
        // arrange
        var solution = new BinaryTreeRightSideView();

        var tree = solution.new TreeNode(1,
                solution.new TreeNode(2,
                        null,
                        solution.new TreeNode(5)),
                solution.new TreeNode(3,
                        null,
                        solution.new TreeNode(4)));

        // act
        var result = solution.rightSideView(tree);

        // assert
        assertEquals(List.of(1, 3, 4), result);
    }
}
