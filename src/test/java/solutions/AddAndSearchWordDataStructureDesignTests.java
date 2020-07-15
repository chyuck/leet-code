package solutions;

import org.junit.Assert;
import org.junit.Test;

public class AddAndSearchWordDataStructureDesignTests {

    @Test
    public void testExample1(){
        var solution = new AddAndSearchWordDataStructureDesign();

        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        Assert.assertFalse(solution.search("pad"));
        Assert.assertTrue(solution.search("bad"));
        Assert.assertTrue(solution.search(".ad"));
        Assert.assertTrue(solution.search("b.."));
    }
}
