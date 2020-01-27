package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConvertSortedArrayToBinarySearchTreeTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new ConvertSortedArrayToBinarySearchTree();

        // act
        var result = solution.sortedArrayToBST(new int[] { -10,-3,0,5,9 });

        // assert
        assertEquals(0, result.val);
        assertEquals(-10, result.left.val);
        assertNull(result.left.left);
        assertEquals(-3, result.left.right.val);
        assertNull(result.left.right.left);
        assertNull(result.left.right.right);
        assertEquals(5, result.right.val);
        assertNull(result.right.left);
        assertEquals(9, result.right.right.val);
        assertNull(result.right.right.left);
        assertNull(result.right.right.right);
    }
}
