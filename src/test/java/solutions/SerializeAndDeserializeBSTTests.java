package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class SerializeAndDeserializeBSTTests {

    @Test
    public void testExample() {
        // arrange
        var solution = new SerializeAndDeserializeBST();

        var input = new TreeNode(2,
                new TreeNode(1, null, null),
                new TreeNode(4,
                        new TreeNode(3, null, null),
                        new TreeNode(5, null, null)));

        // act
        var result = solution.deserialize(solution.serialize(input));

        // assert

        // root
        assertNotNull(result);
        assertEquals(2, result.val);

        // left
        assertNotNull(result.left);
        assertEquals(1, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);

        // right
        assertNotNull(result.right);
        assertEquals(4, result.right.val);
        assertNotNull(result.right.left);
        assertNotNull(result.right.right);

        // right, left
        assertEquals(3, result.right.left.val);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);

        // right, right
        assertEquals(5, result.right.right.val);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}
