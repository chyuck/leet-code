package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/find-median-from-data-stream problem
 * Space complexity: O(n)
 */
public class MedianFinder {

    // max queue to store lower half of elements
    private final PriorityQueue<Integer> maxLowerQueue = new PriorityQueue<>((a, b) -> b - a);
    // min queue to store upper half of elements
    private final PriorityQueue<Integer> minUpperQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));

    /**
     * Time complexity: O(log(n))
     */
    public void addNum(int num) {
        // if no elements in both queues, add to lower queue
        if (maxLowerQueue.size() == 0) {
            addToMaxLowerQueue(num);
            return;
        }

        // if new element is less than or equal to max element in lower queue
        // add to lower queue
        if (maxLowerQueue.peek() >= num) {
            addToMaxLowerQueue(num);
            return;
        }

        // element is greater than max element in lower queue
        // add to upper queue
        addToMinUpperQueue(num);
    }

    private void addToMaxLowerQueue(int num) {
        // add element
        maxLowerQueue.add(num);

        // if lower queue has 2 more element than upper queue
        // move one element from lower queue to upper queue
        if (maxLowerQueue.size() - minUpperQueue.size() > 1)
            minUpperQueue.add(maxLowerQueue.remove());
    }

    private void addToMinUpperQueue(int num) {
        // add element
        minUpperQueue.add(num);

        // if upper queue has more element than lower queue
        // move one element from upper queue to lower queue
        if (minUpperQueue.size() > maxLowerQueue.size())
            maxLowerQueue.add(minUpperQueue.remove());
    }

    /**
     * Time complexity: O(1)
     */
    public double findMedian() {
        // no elements in both queues
        if (maxLowerQueue.size() == 0)
            return 0;

        // when lower queue has 1 more element than upper queue
        // than median is max element of lower queue
        if (maxLowerQueue.size() > minUpperQueue.size())
            return maxLowerQueue.peek();

        // lower and upper queues have equal number of elements
        // than 2 middle elements are max element of lower queue and min element of upper queue
        return (double) (maxLowerQueue.peek() + minUpperQueue.peek()) / 2.0;
    }
}
