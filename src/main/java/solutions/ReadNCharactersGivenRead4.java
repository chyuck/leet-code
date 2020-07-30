package solutions;

/**
 * Solution for https://leetcode.com/problems/read-n-characters-given-read4/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReadNCharactersGivenRead4 {

    public class Solution extends Reader4 {

        public int read(char[] buf, int n) {
            int result = 0;
            char[] buf4 = new char[4];

            while (true) {
                int result4 = read4(buf4);

                for (int i = 0; i < result4 && result < n; i++) {
                    buf[result] = buf4[i];
                    result++;
                }

                if (result4 < 4 || result == n) {
                    break;
                }
            }

            return result;
        }

        public Solution(String file) {
            super(file);
        }
    }

    class Reader4 {
        private final String file;
        private int pointer = 0;

        public Reader4(String file) {
            this.file = file;
        }

        int read4(char[] buf4) {
            int result = 0;

            for (int i = 0; i < 4 && pointer < file.length(); i++) {
                char c = file.charAt(pointer);
                buf4[i] = c;

                pointer++;
                result++;
            }

            return result;
        }
    }
}
