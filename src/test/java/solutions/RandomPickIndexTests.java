package solutions;

import org.junit.Assert;
import org.junit.Test;

public class RandomPickIndexTests {

    @Test
    public void testExample1(){
        int[] nums = new int[] {1,2,3,3,3};
        var solution = new RandomPickIndex(nums);

        int index1 = solution.pick(3);
        Assert.assertTrue(index1 == 2 || index1 == 3 || index1 == 4);

        int index2 = solution.pick(1);
        Assert.assertEquals(0, index2);
    }
}
