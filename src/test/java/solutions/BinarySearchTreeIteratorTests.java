package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class BinarySearchTreeIteratorTests {

    @Test
    public void testExample1(){
        TreeNode root = new TreeNode(7,
            new TreeNode(3),
            new TreeNode(15,
                new TreeNode(9),
                new TreeNode(20)));

        var solution = new BinarySearchTreeIterator(root);

        Assert.assertEquals(3, solution.next());
        Assert.assertEquals(7, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(9, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(15, solution.next());
        Assert.assertTrue(solution.hasNext());
        Assert.assertEquals(20, solution.next());
        Assert.assertFalse(solution.hasNext());
    }
}
