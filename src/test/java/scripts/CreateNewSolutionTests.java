package scripts;

import org.junit.Assert;
import org.junit.Test;

public class CreateNewSolutionTests {

    @Test
    public void testCreateName() {
        // act
        var result = CreateNewSolution.createName("https://leetcode.com/problems/verifying-an-alien-dictionary/");

        // assert
        Assert.assertEquals("VerifyingAnAlienDictionary", result);
    }
}
