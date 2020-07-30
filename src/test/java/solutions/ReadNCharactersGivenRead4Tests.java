package solutions;

import org.junit.Assert;
import org.junit.Test;

public class ReadNCharactersGivenRead4Tests {

    @Test
    public void testExample1(){
        // arrange
        var wrapper = new ReadNCharactersGivenRead4();
        var solution = wrapper.new Solution("abc");

        char[] buf = new char[3];

        // act
        var result = solution.read(buf, 4);

        // assert
        Assert.assertEquals(3, result);
        Assert.assertEquals("abc", new String(buf));
    }

    @Test
    public void testExample2(){
        // arrange
        var wrapper = new ReadNCharactersGivenRead4();
        var solution = wrapper.new Solution("abcde");

        char[] buf = new char[5];

        // act
        var result = solution.read(buf, 5);

        // assert
        Assert.assertEquals(5, result);
        Assert.assertEquals("abcde", new String(buf));
    }

    @Test
    public void testExample3(){
        // arrange
        var wrapper = new ReadNCharactersGivenRead4();
        var solution = wrapper.new Solution("abcdABCD1234");

        char[] buf = new char[12];

        // act
        var result = solution.read(buf, 12);

        // assert
        Assert.assertEquals(12, result);
        Assert.assertEquals("abcdABCD1234", new String(buf));
    }

    @Test
    public void testExample4(){
        // arrange
        var wrapper = new ReadNCharactersGivenRead4();
        var solution = wrapper.new Solution("leetcode");

        char[] buf = new char[5];

        // act
        var result = solution.read(buf, 5);

        // assert
        Assert.assertEquals(5, result);
        Assert.assertEquals("leetc", new String(buf));
    }
}
