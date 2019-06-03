package solutions;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class WordLadderTests {

    @Test public void testExample1ForSolution1() {
        // arrange
        final var solution = new WordLadder();

        // act
        final var result = solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log","cog"));

        // assert
        assertEquals(5, result);
    }

    @Test public void testExample2ForSolution1() {
        // arrange
        final var solution = new WordLadder();

        // act
        final var result = solution.ladderLength("hit", "cog", List.of("hot","dot","dog","lot","log"));

        // assert
        assertEquals(0, result);
    }

    @Test public void testExample1ForSolution2() {
        // arrange
        final var solution = new WordLadder();

        // act
        final var result = solution.ladderLength2("hit", "cog", List.of("hot","dot","dog","lot","log","cog"));

        // assert
        assertEquals(5, result);
    }

    @Test public void testExample2ForSolution2() {
        // arrange
        final var solution = new WordLadder();

        // act
        final var result = solution.ladderLength2("hit", "cog", List.of("hot","dot","dog","lot","log"));

        // assert
        assertEquals(0, result);
    }
}
