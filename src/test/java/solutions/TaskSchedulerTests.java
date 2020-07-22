package solutions;

import org.junit.Assert;
import org.junit.Test;

public class TaskSchedulerTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new TaskScheduler();

        // act
        var result = solution.leastInterval(new char[] { 'A','A','A','B','B','B' }, 2);

        // assert
        Assert.assertEquals(8, result);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new TaskScheduler();

        // act
        var result = solution.leastInterval(new char[] { 'A','A','A','B','B','B' }, 0);

        // assert
        Assert.assertEquals(6, result);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new TaskScheduler();

        // act
        var result = solution.leastInterval(new char[] { 'A','A','A','A','A','A','B','C','D','E','F','G' }, 2);

        // assert
        Assert.assertEquals(16, result);
    }
}
