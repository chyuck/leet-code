package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solutions for https://leetcode.com/problems/pascals-triangle-ii problem with
 * Time complexity: O(k^2)
 * Space complexity: O(k)
 */
public class PascalTriangle2 {

    public List<Integer> getRow(int rowIndex) {
        // initiate result row
        List<Integer> row = new ArrayList<>(rowIndex + 1);

        // add first element, always 1
        row.add(1);

        // loop from row 1 to result row, 1st row already has value
        for (int i = 1; i <= rowIndex; i++) {
            // loop from previous to the last element of row down to second element
            // 1st element already populates, always 1
            // last element will be populated after loop
            for (int j = i - 1; j >= 1; j--) {
                // calculate value from previous row
                int value = row.get(j - 1) + row.get(j);
                // set value for new row
                row.set(j, value);
            }

            // add last element, always 1
            row.add(1);
        }

        return row;
    }
}
