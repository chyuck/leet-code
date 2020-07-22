package solutions;

import org.junit.Assert;
import org.junit.Test;

public class GroupShiftedStringsTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new GroupShiftedStrings();

        String[] input = new String[] { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };

        // act
        var results = solution.groupStrings(input);

        // assert
        Assert.assertEquals(4, results.size());
        Assert.assertArrayEquals(new String[] { "a","z" }, results.get(0).toArray(new String[2]));
        Assert.assertArrayEquals(new String[] { "abc","bcd","xyz" }, results.get(1).toArray(new String[3]));
        Assert.assertArrayEquals(new String[] { "az","ba" }, results.get(2).toArray(new String[2]));
        Assert.assertArrayEquals(new String[] { "acef" }, results.get(3).toArray(new String[1]));

    }
}
