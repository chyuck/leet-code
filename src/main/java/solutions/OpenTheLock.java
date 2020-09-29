package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Solution for https://leetcode.com/problems/open-the-lock/ problem with
 * Time complexity: O(n * a ^ n + d)
 * Space complexity: O(a ^ n + d)
 * where n (=4) - number of lock digits, a (=10) - number of digit alphabet (0-9), d - number of dead ends
 */
public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> blockSet = new HashSet<>(deadends.length);
        for (String deadend : deadends) {
            blockSet.add(deadend);
        }

        if (blockSet.contains("0000") || blockSet.contains(target)) {
            return -1;
        }

        if (target.equals("0000")) {
            return 0;
        }

        int result = 1;

        Set<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> bfs = new LinkedList<>();
        bfs.add("0000");

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                String code = bfs.remove();

                for (String nextCode : getNextCodes(code)) {
                    if (blockSet.contains(nextCode)) {
                        continue;
                    }

                    if (visited.contains(nextCode)) {
                        continue;
                    }

                    if (target.equals(nextCode)) {
                        return result;
                    }

                    bfs.add(nextCode);
                    visited.add(nextCode);
                }
            }

            result++;
        }

        return -1;
    }

    private static List<String> getNextCodes(String code) {
        List<String> results = new ArrayList<>();

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);
            String pre = code.substring(0, i);
            String post = code.substring(i + 1);

            char next1 = c == '9' ? '0' : (char)(c + 1);
            results.add(pre + next1 + post);

            char next2 = c == '0' ? '9' : (char)(c - 1);
            results.add(pre + next2 + post);
        }

        return results;
    }
}
