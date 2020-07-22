package solutions;

import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

public class ValidNumberTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new ValidNumber();

        var cases = new HashMap<String, Boolean>();
        cases.put("0", true);
        cases.put("0", true);
        cases.put(" 0.1 ", true);
        cases.put("abc", false);
        cases.put("1 a", false);
        cases.put("2e10", true);
        cases.put(" -90e3   ", true);
        cases.put(" 1e", false);
        cases.put("e3", false);
        cases.put(" 6e-1", true);
        cases.put(" 99e2.5 ", false);
        cases.put("53.5e93", true);
        cases.put(" --6 ", false);
        cases.put("-+3", false);
        cases.put("95a54e53", false);
        cases.put(".1", true);

        for (var c : cases.entrySet()) {
            // act
            var result = solution.isNumber(c.getKey());

            // assert
            Assert.assertEquals(c.getKey(), c.getValue(), result);
        }
    }
}
