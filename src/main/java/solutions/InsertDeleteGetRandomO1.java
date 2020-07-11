package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Solution for https://leetcode.com/problems/insert-delete-getrandom-o1/ problem with
 * Time complexity: O(1) average
 * Space complexity: O(n)
 * where n - max number of values at any time
 */
public class InsertDeleteGetRandomO1 {

    private final List<Integer> values = new ArrayList<>();
    private final Map<Integer, Integer> indexes = new HashMap<>();

    public boolean insert(int val) {
        if (indexes.containsKey(val)) {
            return false;
        }

        values.add(val);
        indexes.put(val, values.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        Integer index = indexes.get(val);
        if (index == null) {
            return false;
        }

        int lastIndex = values.size() - 1;
        Integer lastValue = values.remove(lastIndex);

        if (index != lastIndex) {
            values.set(index, lastValue);
            indexes.put(lastValue, index);
        }

        indexes.remove(val);

        return true;
    }

    private final Random random = new Random();

    public int getRandom() {
        int index = random.nextInt(values.size());

        return values.get(index);
    }
}
