package solutions;

/**
 * Solution for https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/ problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class ReadNCharactersGivenRead42 {

    public class Solution extends Reader4 {

        private int pointer = 4;
        private int size = 4;
        private final char[] buffer = new char[4];
        boolean endOfFile = false;

        public int read(char[] buf, int n) {
            int result = 0;

            for (int i = 0; i < n; i++) {
                Character nextChar = getNextChar();
                if (nextChar == null) {
                    break;
                }

                buf[i] = nextChar;
                result++;
            }

            return result;
        }

        private Character getNextChar() {
            if (endOfFile) {
                return null;
            }

            if (pointer < size) {
                return buffer[pointer++];
            } else {
                if (size < 4) {
                    endOfFile = true;
                    return null;
                }

                size = read4(buffer);
                pointer = 0;

                if (size == 0) {
                    endOfFile = true;
                    return null;
                }

                return buffer[pointer++];
            }
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