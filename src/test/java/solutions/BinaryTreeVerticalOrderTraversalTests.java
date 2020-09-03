package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class BinaryTreeVerticalOrderTraversalTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new BinaryTreeVerticalOrderTraversal();

        var root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)));

        // act
        var results = solution.verticalOrder(root);

        // assert
        Assert.assertEquals(4, results.size());
        Assert.assertArrayEquals(new Object[] { 9 }, results.get(0).toArray());
        Assert.assertArrayEquals(new Object[] { 3,15 }, results.get(1).toArray());
        Assert.assertArrayEquals(new Object[] { 20 }, results.get(2).toArray());
        Assert.assertArrayEquals(new Object[] { 7 }, results.get(3).toArray());
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new BinaryTreeVerticalOrderTraversal();

        var root = new TreeNode(3,
            new TreeNode(9,
                new TreeNode(4),
                new TreeNode(0)),
            new TreeNode(8,
                new TreeNode(1),
                new TreeNode(7)));

        // act
        var results = solution.verticalOrder(root);

        // assert
        Assert.assertEquals(5, results.size());
        Assert.assertArrayEquals(new Object[] { 4 }, results.get(0).toArray());
        Assert.assertArrayEquals(new Object[] { 9 }, results.get(1).toArray());
        Assert.assertArrayEquals(new Object[] { 3,0,1 }, results.get(2).toArray());
        Assert.assertArrayEquals(new Object[] { 8 }, results.get(3).toArray());
        Assert.assertArrayEquals(new Object[] { 7 }, results.get(4).toArray());
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new BinaryTreeVerticalOrderTraversal();

        var root = new TreeNode(3,
            new TreeNode(9,
                new TreeNode(4),
                new TreeNode(0,
                    null,
                    new TreeNode(2))),
            new TreeNode(8,
                new TreeNode(1,
                    new TreeNode(5),
                    null),
                new TreeNode(7)));

        // act
        var results = solution.verticalOrder(root);

        // assert
        Assert.assertEquals(5, results.size());
        Assert.assertArrayEquals(new Object[] { 4 }, results.get(0).toArray());
        Assert.assertArrayEquals(new Object[] { 9,5 }, results.get(1).toArray());
        Assert.assertArrayEquals(new Object[] { 3,0,1 }, results.get(2).toArray());
        Assert.assertArrayEquals(new Object[] { 8,2 }, results.get(3).toArray());
        Assert.assertArrayEquals(new Object[] { 7 }, results.get(4).toArray());
    }
}
