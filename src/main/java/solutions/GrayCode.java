package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/gray-code/ problem with
 * Time complexity: O(2^n)
 * Space complexity: O(2^n)
 */
public class GrayCode {

    public List<Integer> grayCode(int n) {
        // create results
        List<Integer> results = new ArrayList<>();
        // add zero to results
        results.add(0);

        // the idea to generate results with n bits from results with n-1 bits
        // by adding 1 bit at the beginning and
        // process results n-1 bits in reverse order to have two successive values differ in only one bit
        // n = 0 -> 0
        // n = 1 -> 0, 1
        // n = 2 -> 00, 01, 11, 10
        // n = 3 -> 000, 001, 011, 010, 110, 111, 101, 100

        // iterate from 1 to n, zero already processed
        for (int i = 0; i < n; i++) {
            // save size of results with n-1 bits
            int size = results.size();
            // process results with n-1 bits in reverse order
            for (int j = size - 1; j >= 0; j--) {
                // get value
                Integer value = results.get(j);
                // generate a new value by adding 1 bit at the beginning
                Integer newValue = value | 1 << i;
                // add new value to results
                results.add(newValue);
            }
        }

        // return results
        return results;
    }
}
