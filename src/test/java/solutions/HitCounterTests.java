package solutions;

import org.junit.Assert;
import org.junit.Test;

public class HitCounterTests {

    @Test
    public void testExample1(){
        var counter = new HitCounter();

        counter.hit(1);

        counter.hit(2);

        counter.hit(3);

        Assert.assertEquals(3, counter.getHits(4));

        counter.hit(300);

        Assert.assertEquals(4, counter.getHits(300));

        Assert.assertEquals(3, counter.getHits(301));
    }
}
