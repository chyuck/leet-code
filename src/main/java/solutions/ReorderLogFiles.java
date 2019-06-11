package solutions;

import java.util.*;

/**
 * Solution for https://leetcode.com/problems/reorder-log-files problem with
 * Time complexity: O(n * log(n))
 * Space complexity: O(n)
 * where n - total content of all logs
 */
public class ReorderLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        if (logs == null || logs.length == 0)
            return logs;

        // sort with custom comparator
        Arrays.sort(logs, (log1, log2) -> {
            // find indexes of first space, separator of identifier and content
            final int separatorIndex1 = log1.indexOf(' ');
            final int separatorIndex2 = log2.indexOf(' ');

            // check whether logs are "digit"
            final boolean isDigitLog1 = Character.isDigit(log1.charAt(separatorIndex1 + 1));
            final boolean isDigitLog2 = Character.isDigit(log2.charAt(separatorIndex2 + 1));

            // both logs are "digit" logs, keep in the same order
            if (isDigitLog1 && isDigitLog2)
                return 0;

            // 1st - "digit" log, 2nd "letter" log, "digit" log is bigger than "letter" log
            if (isDigitLog1)
                return 1;

            // 1st - "letter" log, 2nd "digit" log, "letter" log is smaller than "digit" log
            if (isDigitLog2)
                return -1;

            // both "letter" logs, compare contents
            final String content1 = log1.substring(separatorIndex1 + 1);
            final String content2 = log2.substring(separatorIndex2 + 1);
            final int compare = content1.compareTo(content2);
            // if contents are different, return compare result
            if (compare != 0)
                return compare;

            // contents are the same, compare identifiers and return result
            final String identifier1 = log1.substring(0, separatorIndex1);
            final String identifier2 = log2.substring(0, separatorIndex2);
            return identifier1.compareTo(identifier2);
        });

        return logs;
    }
}
