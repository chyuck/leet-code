package solutions;

import org.junit.Test;
import java.util.List;

import structures.TreeNode;

import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTests {

    @Test public void testExample() {
        // arrange
        var solution = new BinaryTreeRightSideView();

        var tree = new TreeNode(1,
                new TreeNode(2,
                        null,
                        new TreeNode(5)),
                new TreeNode(3,
                        null,
                        new TreeNode(4)));

        // act
        var result = solution.rightSideView(tree);

        // assert
        assertEquals(List.of(1, 3, 4), result);
    }
}
