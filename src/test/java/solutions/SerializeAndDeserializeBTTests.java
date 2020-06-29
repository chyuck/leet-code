package solutions;

import org.junit.Test;

import structures.TreeNode;

import static org.junit.Assert.*;

public class SerializeAndDeserializeBTTests {

    @Test public void testExample() {
        // arrange
        final var solution = new SerializeAndDeserializeBT();

        final var input = new TreeNode(1,
            new TreeNode(2, null, null),
            new TreeNode(3,
                new TreeNode(4, null, null),
                new TreeNode(5, null, null)));

        // act
        final var result = solution.deserialize(solution.serialize(input));

        // assert

        // root
        assertNotNull(result);
        assertEquals(1, result.val);

        // left
        assertNotNull(result.left);
        assertEquals(2, result.left.val);
        assertNull(result.left.left);
        assertNull(result.left.right);

        // right
        assertNotNull(result.right);
        assertEquals(3, result.right.val);
        assertNotNull(result.right.left);
        assertNotNull(result.right.right);

        // right, left
        assertEquals(4, result.right.left.val);
        assertNull(result.right.left.left);
        assertNull(result.right.left.right);

        // right, right
        assertEquals(5, result.right.right.val);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}
