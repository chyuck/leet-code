package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions for https://leetcode.com/problems/pascals-triangle problem with
 * Time complexity: O(n^2)
 * Space complexity: O(n^2)
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> results = new ArrayList<>();

        if (numRows == 0) {
            return results;
        }

        List<Integer> prev = new ArrayList<>();
        prev.add(1);
        results.add(prev);

        for (int i = 2; i <= numRows; i++) {
            List<Integer> curr = new ArrayList<>();

            Integer prevNum = null;
            for (Integer num : prev) {
                if (prevNum == null) {
                    curr.add(num);
                } else {
                    curr.add(prevNum + num);
                }

                prevNum = num;
            }

            curr.add(1);

            results.add(curr);
            prev = curr;
        }

        return results;
    }
}
