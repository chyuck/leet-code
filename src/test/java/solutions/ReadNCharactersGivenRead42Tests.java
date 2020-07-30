package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ReadNCharactersGivenRead42Tests {

    @Test
    public void testExample1(){
        var wrapper = new ReadNCharactersGivenRead42();
        var solution = wrapper.new Solution("abc");

        char[] buf1 = new char[1];
        var result1 = solution.read(buf1, 1);
        Assert.assertEquals(1, result1);
        Assert.assertEquals("a", new String(buf1));

        char[] buf2 = new char[2];
        var result2 = solution.read(buf2, 2);
        Assert.assertEquals(2, result2);
        Assert.assertEquals("bc", new String(buf2));

        char[] buf3 = new char[0];
        var result3 = solution.read(buf3, 1);
        Assert.assertEquals(0, result3);
    }

    @Test
    public void testExample2(){
        var wrapper = new ReadNCharactersGivenRead42();
        var solution = wrapper.new Solution("abc");

        char[] buf1 = new char[3];
        var result1 = solution.read(buf1, 4);
        Assert.assertEquals(3, result1);
        Assert.assertEquals("abc", new String(buf1));

        char[] buf2 = new char[0];
        var result2 = solution.read(buf2, 1);
        Assert.assertEquals(0, result2);
    }
}
