package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Solution for https://leetcode.com/problems/find-and-replace-in-string/ problem with
 * Time complexity: O(S * I)
 * Space complexity: O(I + S * T)
 * where S - length of S, I - length of "indexes" array, T - max length of string in "targets" array
 */
public class FindAndReplaceInString {

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String[]> replaces = new HashMap<>(indexes.length);
        for (int i = 0; i < indexes.length; i++) {
            replaces.put(indexes[i], new String[] { sources[i], targets[i] });
        }

        StringBuilder result = new StringBuilder();

        int index = 0;
        while(index < S.length()) {
            String[] replace = replaces.get(index);

            if (replace == null) {
                result.append(S.charAt(index));
                index++;
            } else {
                int sourceLength = replace[0].length();
                String source = S.substring(index, index + sourceLength);

                if (Objects.equals(source, replace[0])) {
                    result.append(replace[1]);
                } else {
                    result.append(source);
                }
                index += sourceLength;
            }
        }

        return result.toString();
    }
}
