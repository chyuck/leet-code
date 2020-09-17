package solutions;

import org.junit.Assert;
import org.junit.Test;

import structures.TreeNode;

public class FlipEquivalentBinaryTreesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new FlipEquivalentBinaryTrees();

        var root1 = new TreeNode(1,
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(7),
                    new TreeNode(8))),
            new TreeNode(3,
                new TreeNode(6),
                null));

        var root2 = new TreeNode(1,
            new TreeNode(3,
                null,
                new TreeNode(6)),
            new TreeNode(2,
                new TreeNode(4),
                new TreeNode(5,
                    new TreeNode(8),
                    new TreeNode(7))));

        // act
        var result = solution.flipEquiv(root1, root2);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new FlipEquivalentBinaryTrees();

        // act
        var result = solution.flipEquiv(null, null);

        // assert
        Assert.assertTrue(result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new FlipEquivalentBinaryTrees();

        // act
        var result = solution.flipEquiv(null, new TreeNode(1));

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new FlipEquivalentBinaryTrees();

        var root1 = new TreeNode(0,
            null,
            new TreeNode(1));

        // act
        var result = solution.flipEquiv(root1, null);

        // assert
        Assert.assertFalse(result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new FlipEquivalentBinaryTrees();

        var root1 = new TreeNode(0,
            null,
            new TreeNode(1));

        var root2 = new TreeNode(0,
            new TreeNode(1),
            null);

        // act
        var result = solution.flipEquiv(root1, root2);

        // assert
        Assert.assertTrue(result);
    }
}
