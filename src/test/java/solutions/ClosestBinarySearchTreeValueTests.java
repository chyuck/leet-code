package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class ClosestBinarySearchTreeValueTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ClosestBinarySearchTreeValue();

        var root = new TreeNode(4,
            new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3)),
            new TreeNode(5));

        // act
        var result = solution.closestValue(root, 3.714286);

        // assert
        Assert.assertEquals(4, result);
    }
}
