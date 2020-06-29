package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class KthSmallestElementInBSTTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new KthSmallestElementInBST();

        TreeNode input =
            new TreeNode(3,
                new TreeNode(1,
                    null,
                    new TreeNode(2)),
                new TreeNode(4));

        // act
        var result = solution.kthSmallest(input, 1);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new KthSmallestElementInBST();

        TreeNode input =
            new TreeNode(5,
                new TreeNode(3,
                    new TreeNode(2,
                        new TreeNode(1),
                        null),
                    new TreeNode(4)),
                new TreeNode(6));

        // act
        var result = solution.kthSmallest(input, 3);

        // assert
        Assert.assertEquals(3, result);
    }
}
