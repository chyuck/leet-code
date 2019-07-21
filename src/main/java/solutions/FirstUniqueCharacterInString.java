package solutions;

/**
 * Solution for https://leetcode.com/problems/first-unique-character-in-a-string problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        if (s.length() == 1) return 0;

        // create array of counts of each character
        int[] counts = new int['z' - 'a' + 1];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            counts[index]++;
        }

        // iterate through string and find first letter with count is equal to 1
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (counts[index] == 1)
                return i;
        }

        // no unique letter
        return -1;
    }
}
