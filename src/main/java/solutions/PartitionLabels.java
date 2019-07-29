package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/partition-labels problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        List<Integer> results = new ArrayList<>();

        if (S == null || S.length() == 0)
            return results;

        // create array with last index of each letter
        int[] last = new int['z' - 'a' + 1];
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            last[ch - 'a'] = i;
        }

        // create variables to track start and last index of part
        int start = 0;
        int end = 0;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            // calculate last index of part, which is last index among all characters in current part
            end = Math.max(end, last[ch - 'a']);
            // if current index is the last index of part
            // then add current part to results
            // and start next part
            if (i == end) {
                int partSize = end - start + 1;
                results.add(partSize);
                start = end + 1;
            }
        }

        return results;
    }
}
