package solutions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class AccountsMergeTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new AccountsMerge();

        var accounts = Arrays.asList(
            Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
            Arrays.asList("John", "johnnybravo@mail.com"),
            Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
            Arrays.asList("Mary", "mary@mail.com"));

        // act
        var results = solution.accountsMerge(accounts);

        // assert
        Assert.assertEquals(3, results.size());

        Assert.assertArrayEquals(
            new Object[] { "John", "johnnybravo@mail.com" },
            results.get(0).toArray());

        Assert.assertArrayEquals(
            new Object[] { "John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com" },
            results.get(1).toArray());

        Assert.assertArrayEquals(
            new Object[] { "Mary", "mary@mail.com" },
            results.get(2).toArray());
    }
}
