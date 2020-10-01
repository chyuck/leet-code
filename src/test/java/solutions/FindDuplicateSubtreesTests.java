package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class FindDuplicateSubtreesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new FindDuplicateSubtrees();

        var root = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                null),
            new TreeNode(3,
                new TreeNode(2,
                    new TreeNode(4),
                    null),
                new TreeNode(4)));

        // act
        var result = solution.findDuplicateSubtrees(root);

        // assert
        Assert.assertEquals(2, result.size());

        Assert.assertEquals(4, result.get(0).val);
        Assert.assertNull(result.get(0).left);
        Assert.assertNull(result.get(0).right);

        Assert.assertEquals(2, result.get(1).val);
        Assert.assertEquals(4, result.get(1).left.val);
        Assert.assertNull(result.get(1).left.left);
        Assert.assertNull(result.get(1).left.right);
        Assert.assertNull(result.get(1).right);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new FindDuplicateSubtrees();

        var root = new TreeNode(2,
            new TreeNode(1),
            new TreeNode(1));

        // act
        var result = solution.findDuplicateSubtrees(root);

        // assert
        Assert.assertEquals(1, result.size());

        Assert.assertEquals(1, result.get(0).val);
        Assert.assertNull(result.get(0).left);
        Assert.assertNull(result.get(0).right);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new FindDuplicateSubtrees();

        var root = new TreeNode(2,
            new TreeNode(2,
                new TreeNode(3),
                null),
            new TreeNode(2,
                new TreeNode(3),
                null));

        // act
        var result = solution.findDuplicateSubtrees(root);

        // assert
        Assert.assertEquals(2, result.size());

        Assert.assertEquals(3, result.get(0).val);
        Assert.assertNull(result.get(0).left);
        Assert.assertNull(result.get(0).right);

        Assert.assertEquals(2, result.get(1).val);
        Assert.assertEquals(3, result.get(1).left.val);
        Assert.assertNull(result.get(1).left.left);
        Assert.assertNull(result.get(1).left.right);
        Assert.assertNull(result.get(1).right);
    }
}
