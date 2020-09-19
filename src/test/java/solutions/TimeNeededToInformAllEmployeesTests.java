package solutions;

import org.junit.Assert;
import org.junit.Test;

public class TimeNeededToInformAllEmployeesTests {

    @Test
    public void testExample1() {
        // arrange
        var solution = new TimeNeededToInformAllEmployees();

        // act
        var result = solution.numOfMinutes(1, 0, new int[] { -1 }, new int[] { 0 });

        // assert
        Assert.assertEquals(0, result);
    }

    @Test
    public void testExample2() {
        // arrange
        var solution = new TimeNeededToInformAllEmployees();

        // act
        var result = solution.numOfMinutes(6, 2, new int[] { 2,2,-1,2,2,2 }, new int[] { 0,0,1,0,0,0 });

        // assert
        Assert.assertEquals(1, result);
    }

    @Test
    public void testExample3() {
        // arrange
        var solution = new TimeNeededToInformAllEmployees();

        // act
        var result = solution.numOfMinutes(7, 6, new int[] { 1,2,3,4,5,6,-1 }, new int[] { 0,6,5,4,3,2,1 });

        // assert
        Assert.assertEquals(21, result);
    }

    @Test
    public void testExample4() {
        // arrange
        var solution = new TimeNeededToInformAllEmployees();

        // act
        var result = solution.numOfMinutes(15, 0, new int[] { -1,0,0,1,1,2,2,3,3,4,4,5,5,6,6 },
            new int[] { 1,1,1,1,1,1,1,0,0,0,0,0,0,0,0 });

        // assert
        Assert.assertEquals(3, result);
    }

    @Test
    public void testExample5() {
        // arrange
        var solution = new TimeNeededToInformAllEmployees();

        // act
        var result = solution.numOfMinutes(4, 2, new int[] { 3,3,-1,2 }, new int[] { 0,0,162,914 });

        // assert
        Assert.assertEquals(1076, result);
    }
}
