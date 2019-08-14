package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution for https://leetcode.com/problems/group-anagrams problem with
 * Time complexity: O(n * k)
 * Space complexity: O(n * k)
 * where n - number of input strings, k - max length of input string
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // create hash map to map string with counts of all characters separated by '!'
        // to list of input strings that match key
        Map<String, List<String>> results = new HashMap<>();

        // loop through input strings
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];

            // calculate counts of all characters in array of integers
            int[] counts = new int[26];
            for (int j = 0; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                counts[index]++;
            }

            // create hash map key from counts of characters
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < counts.length; j++) {
                builder.append(counts[j]);
                builder.append("!");
            }
            String key = builder.toString();

            // create hash map record if it does not exist
            if (!results.containsKey(key))
                results.put(key, new ArrayList<>());

            // add current input string to appropriate key
            results.get(key).add(str);
        }

        // return all grouped input strings
        return new ArrayList<>(results.values());
    }
}
