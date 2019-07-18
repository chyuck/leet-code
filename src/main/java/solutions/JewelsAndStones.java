package solutions;

/**
 * Solution for https://leetcode.com/problems/jewels-and-stones/ problem with
 * Time complexity: O(J + S)
 * Space complexity: O(1)
 * where J - number of jewels, S - number of stones
 */
public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        if (J.length() == 0) return 0;
        if (S.length() == 0) return 0;

        // create jewel boolean array with all possible 52 stones
        boolean[] jewels = new boolean['Z' - 'A' + 'z' - 'a' + 2];
        for (int i = 0; i < J.length(); i++) {
            char jewel = J.charAt(i);
            // calculate index of jewel stone
            int index = getIndex(jewel);
            jewels[index] = true;
        }

        int result = 0;

        // loop through stones
        for (int i = 0; i < S.length(); i++) {
            char stone = S.charAt(i);
            // calculate index of stone
            int index = getIndex(stone);
            // if stone is jewel, then increment result
            if (jewels[index]) {
                result++;
            }
        }

        return result;
    }

    private static int getIndex(char stone) {
        // convert 'a' - 'z' to 0 - 25 index
        if ('a' <= stone && stone <= 'z')
            return stone - 'a';

        // assume that 'z' is not following by 'A'
        // convert 'A' - 'Z' to 26 - 51 index
        return stone - 'A' + 'z' - 'a' + 1;
    }
}
