package solutions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class CloneGraphTests {

    @Test
    public void testExample1(){
        // arrange
        var solution = new CloneGraph();

        var node1 = new CloneGraph.Node(1);
        var node2 = new CloneGraph.Node(2);
        var node3 = new CloneGraph.Node(3);
        var node4 = new CloneGraph.Node(4);

        node1.neighbors.addAll(Arrays.asList(node2, node4));
        node2.neighbors.addAll(Arrays.asList(node1, node3));
        node3.neighbors.addAll(Arrays.asList(node2, node4));
        node4.neighbors.addAll(Arrays.asList(node1, node3));

        // act
        var result1 = solution.cloneGraph(node1);

        // assert
        Assert.assertEquals(1, result1.val);
        Assert.assertNotSame(node1, result1);
        Assert.assertEquals(2, result1.neighbors.size());

        var result2 = result1.neighbors.get(0);
        Assert.assertEquals(2, result2.val);
        Assert.assertNotSame(node2, result2);
        Assert.assertEquals(2, result2.neighbors.size());


        var result3 = result2.neighbors.get(1);
        Assert.assertEquals(3, result3.val);
        Assert.assertNotSame(node3, result3);
        Assert.assertEquals(2, result3.neighbors.size());

        var result4 = result1.neighbors.get(1);
        Assert.assertEquals(4, result4.val);
        Assert.assertNotSame(node4, result4);
        Assert.assertEquals(2, result4.neighbors.size());

        Assert.assertSame(result2, result1.neighbors.get(0));
        Assert.assertSame(result4, result1.neighbors.get(1));

        Assert.assertSame(result1, result2.neighbors.get(0));
        Assert.assertSame(result3, result2.neighbors.get(1));

        Assert.assertSame(result2, result3.neighbors.get(0));
        Assert.assertSame(result4, result3.neighbors.get(1));

        Assert.assertSame(result1, result4.neighbors.get(0));
        Assert.assertSame(result3, result4.neighbors.get(1));
    }

    @Test
    public void testExample2(){
        // arrange
        var solution = new CloneGraph();

        var node1 = new CloneGraph.Node(1);

        // act
        var result1 = solution.cloneGraph(node1);

        // assert
        Assert.assertEquals(1, result1.val);
        Assert.assertNotSame(node1, result1);
        Assert.assertEquals(0, result1.neighbors.size());
    }

    @Test
    public void testExample3(){
        // arrange
        var solution = new CloneGraph();

        // act
        var result = solution.cloneGraph(null);

        // assert
        Assert.assertNull(result);
    }

    @Test
    public void testExample4(){
        // arrange
        var solution = new CloneGraph();

        var node1 = new CloneGraph.Node(1);
        var node2 = new CloneGraph.Node(2);

        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        // act
        var result1 = solution.cloneGraph(node1);

        // assert
        Assert.assertEquals(1, result1.val);
        Assert.assertNotSame(node1, result1);
        Assert.assertEquals(1, result1.neighbors.size());

        var result2 = result1.neighbors.get(0);
        Assert.assertEquals(2, result2.val);
        Assert.assertNotSame(node2, result2);
        Assert.assertEquals(1, result2.neighbors.size());

        Assert.assertSame(result2, result1.neighbors.get(0));
        Assert.assertSame(result1, result2.neighbors.get(0));
    }
}
