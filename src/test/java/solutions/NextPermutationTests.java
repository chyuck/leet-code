package solutions;

import org.junit.Assert;
import org.junit.Test;

public class NextPermutationTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new NextPermutation();

        var nums = new int[] {1,2,3};

        // act
        solution.nextPermutation(nums);

        // assert
        Assert.assertArrayEquals(new int[] {1,3,2}, nums);
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new NextPermutation();

        var nums = new int[] {3,2,1};

        // act
        solution.nextPermutation(nums);

        // assert
        Assert.assertArrayEquals(new int[] {1,2,3}, nums);
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new NextPermutation();

        var nums = new int[] {1,1,5};

        // act
        solution.nextPermutation(nums);

        // assert
        Assert.assertArrayEquals(new int[] {1,5,1}, nums);
    }

    @Test
    public void testCase1(){
        // arrange
        var solution = new NextPermutation();

        var nums = new int[] {1,3,2};

        // act
        solution.nextPermutation(nums);

        // assert
        Assert.assertArrayEquals(new int[] {2,1,3}, nums);
    }
}
