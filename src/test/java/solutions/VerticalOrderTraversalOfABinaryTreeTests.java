package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class VerticalOrderTraversalOfABinaryTreeTests {

    @Test
    public void testExample1(){
        // arrange
        TreeNode root = new TreeNode(3,
            new TreeNode(9),
            new TreeNode(20,
                new TreeNode(15),
                new TreeNode(7)));

        var solution = new VerticalOrderTraversalOfABinaryTree();

        // act
        var results = solution.verticalTraversal(root);

        // assert
        Assert.assertEquals(4, results.size());

        Assert.assertEquals(1, results.get(0).size());
        Assert.assertEquals((Integer) 9, results.get(0).get(0));

        Assert.assertEquals(2, results.get(1).size());
        Assert.assertEquals((Integer) 3, results.get(1).get(0));
        Assert.assertEquals((Integer) 15, results.get(1).get(1));

        Assert.assertEquals(1, results.get(2).size());
        Assert.assertEquals((Integer) 20, results.get(2).get(0));

        Assert.assertEquals(1, results.get(3).size());
        Assert.assertEquals((Integer) 7, results.get(3).get(0));
    }

    @Test
    public void testExample2(){
        // arrange
        TreeNode root = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5)),
            new TreeNode(3,
                new TreeNode(6),
                new TreeNode(7)));

        var solution = new VerticalOrderTraversalOfABinaryTree();

        // act
        var results = solution.verticalTraversal(root);

        // assert
        Assert.assertEquals(5, results.size());

        Assert.assertEquals(1, results.get(0).size());
        Assert.assertEquals((Integer) 4, results.get(0).get(0));

        Assert.assertEquals(1, results.get(1).size());
        Assert.assertEquals((Integer) 2, results.get(1).get(0));

        Assert.assertEquals(3, results.get(2).size());
        Assert.assertEquals((Integer) 1, results.get(2).get(0));
        Assert.assertEquals((Integer) 5, results.get(2).get(1));
        Assert.assertEquals((Integer) 6, results.get(2).get(2));

        Assert.assertEquals(1, results.get(3).size());
        Assert.assertEquals((Integer) 3, results.get(3).get(0));

        Assert.assertEquals(1, results.get(4).size());
        Assert.assertEquals((Integer) 7, results.get(4).get(0));
    }
}
