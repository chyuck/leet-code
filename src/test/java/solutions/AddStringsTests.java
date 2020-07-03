package solutions;

import org.junit.Assert;
import org.junit.Test;

public class AddStringsTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new AddStrings();

        // act
        var result = solution.addStrings("1234", "99704");

        // assert
        Assert.assertEquals("100938", result);
    }
}
