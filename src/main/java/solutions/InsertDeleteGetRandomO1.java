package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/insert-delete-getrandom-o1/ problem with
 * Time complexity: O(1) average
 * Space complexity: O(n)
 * where n - max number of values at any time
 */
public class InsertDeleteGetRandomO1 {

    private final List<Integer> array = new ArrayList<>();
    private final Map<Integer, Integer> map = new HashMap<>();

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        // if value exists, then return false
        if (map.containsKey(val))
            return false;

        // add value to hash map with index in array
        map.put(val, array.size());
        // add value to array
        array.add(val);

        // return true, because value is new
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        // if value does not exist, then return false
        if (!map.containsKey(val))
            return false;

        // remove value from hash map and save index
        int index = map.remove(val);
        // save last index
        int lastIndex = array.size() - 1;

        // if value is the last value in array, then remove it and return true
        if (index == lastIndex) {
            array.remove(index);
            return true;
        }

        // save last value
        Integer lastValue = array.get(lastIndex);
        // remove last value
        array.remove(lastIndex);
        // set last value instead of value, to preserve indexes for the rest of values
        array.set(index, lastValue);
        // update index for last value in hash map
        map.put(lastValue, index);

        // return true because value was removed
        return true;
    }

    private final Random random = new Random();

    /** Get a random element from the set. */
    public int getRandom() {
        // generate randomly index of array
        int randomIndex = random.nextInt(array.size());

        // return value at random index
        return array.get(randomIndex);
    }
}
