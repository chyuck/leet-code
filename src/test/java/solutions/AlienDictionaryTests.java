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
}
