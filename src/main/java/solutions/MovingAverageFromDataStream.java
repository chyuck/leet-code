package solutions;

import java.util.LinkedList;

/**
 * Solution for https://leetcode.com/problems/moving-average-from-data-stream/ problem with
 * Time complexity: O(1)
 * Space complexity: O(n)
 * where n - size of window
 */
public class MovingAverageFromDataStream {

    private final LinkedList<Integer> list = new LinkedList<>();
    private final int size;

    private int sum = 0;

    public MovingAverageFromDataStream(int size) {
        this.size = size;
    }

    public double next(int val) {
        list.addLast(val);
        sum += val;

        if (list.size() > size) {
            int first = list.removeFirst();
            sum -= first;
        }

        return (double) sum / (double) list.size();
    }
}
