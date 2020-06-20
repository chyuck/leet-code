package solutions;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestElementInBSTTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new KthSmallestElementInBST();

        KthSmallestElementInBST.TreeNode input =
                solution.new TreeNode(3,
                        solution.new TreeNode(1,
                            null,
                                solution.new TreeNode(2)),
                        solution.new TreeNode(4));

        // act
        var result = solution.kthSmallest(input, 1);

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new KthSmallestElementInBST();

        KthSmallestElementInBST.TreeNode input =
                solution.new TreeNode(5,
                        solution.new TreeNode(3,
                                solution.new TreeNode(2,
                                        solution.new TreeNode(1),
                                        null),
                                solution.new TreeNode(4)),
                        solution.new TreeNode(6));

        // act
        var result = solution.kthSmallest(input, 3);

        // assert
        Assert.assertEquals(3, result);
    }
}
