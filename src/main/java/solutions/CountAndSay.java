package solutions;

/**
 * Solution for https://leetcode.com/problems/count-and-say/ problem with
 * Time complexity: O(n ^ 2)
 * Space complexity: O(n ^ 2)
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n < 1) {
            return "";
        }

        String result = "1";

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            int count = 1;
            char prev = result.charAt(0);

            for (int j = 1; j < result.length(); j++) {
                char curr = result.charAt(j);
                if (curr == prev) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(prev);

                    count = 1;
                    prev = curr;
                }
            }

            sb.append(count);
            sb.append(prev);

            result = sb.toString();
        }

        return result;
    }
}
