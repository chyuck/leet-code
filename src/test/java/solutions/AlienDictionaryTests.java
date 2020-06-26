package solutions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AlienDictionaryTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" });

        // assert
        assertEquals("wertf", result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "z", "x" });

        // assert
        assertEquals("zx", result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "z", "x", "z" });

        // assert
        assertEquals("", result);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "za","zb","ca","cb" });

        // assert
        assertEquals("zcab", result);
    }

    @Test
    public void testCase2(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "abc", "ab" });

        // assert
        assertEquals("", result);
    }

    @Test
    public void testCase3(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "z", "z" });

        // assert
        assertEquals("z", result);
    }

    @Test
    public void testCase4(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "wrt","wrtkj" });

        // assert
        assertEquals("kjwtr", result);
    }

    @Test
    public void testCase5(){
        // arrange
        var solution = new AlienDictionary();

        // act
        var result = solution.alienOrder(new String[] { "wnlb" });

        // assert
        assertEquals("nlwb", result);
    }
}
