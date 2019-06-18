package solutions;

/**
 * Solutions for https://leetcode.com/problems/compare-version-numbers problem with
 * Time complexity: O(n + m)
 * where n, m - lengths of two versions
 */
public class CompareVersionNumbers {

    private char getCharForCompare(String version, int pointer) {
        // end of version part is lower than '0'
        return !endOfVersionPart(version, pointer) ? version.charAt(pointer) : '0' - 1;
    }

    private boolean endOfVersion(String version, int pointer) {
        return pointer >= version.length();
    }

    private boolean endOfVersionPart(String version, int pointer) {
        return endOfVersion(version, pointer) || version.charAt(pointer) == '.';
    }

    private int skipLeadingZeros(String version, int pointer) {
        // increment pointer until it reaches end of part or non zero character
        while (!endOfVersionPart(version, pointer) && version.charAt(pointer) == '0') {
            pointer++;
        }

        return pointer;
    }

    /**
     * Space complexity: O(1)
     */
    public int compareVersion(String version1, String version2) {

        int pointer1 = 0, pointer2 = 0;
        int partLength1 = 0, partLength2 = 0;
        int tempResult = 0;

        while (!endOfVersion(version1, pointer1) || !endOfVersion(version2, pointer2)) {

            // ignore leading zeroes for new part
            if (partLength1 == 0) pointer1 = skipLeadingZeros(version1, pointer1);
            if (partLength2 == 0) pointer2 = skipLeadingZeros(version2, pointer2);

            // move to the next part
            if (endOfVersionPart(version1, pointer1) && endOfVersionPart(version2, pointer2)) {
                // that means both parts have the same length
                // if temp result is not 0, then return it
                if (tempResult != 0)
                    return tempResult;

                // increment only if it is not end of version
                if (!endOfVersion(version1, pointer1)) {
                    pointer1++;
                    partLength1 = 0;
                }
                if (!endOfVersion(version2, pointer2)) {
                    pointer2++;
                    partLength2 = 0;
                }

                // start new part
                continue;
            }

            // compare characters from versions, end of part is lower than '0'
            char charForCompare1 = getCharForCompare(version1, pointer1);
            char charForCompare2 = getCharForCompare(version2, pointer2);

            // save compare result to temp result, it will be used only if parts have different length
            // do not override result
            if (tempResult == 0 && charForCompare1 > charForCompare2)
                tempResult = 1;

            if (tempResult == 0 && charForCompare1 < charForCompare2)
                tempResult = -1;

            // increment pointers and length
            if (!endOfVersionPart(version1, pointer1)) {
                pointer1++;
                partLength1++;
            }

            if (!endOfVersionPart(version2, pointer2)) {
                pointer2++;
                partLength2++;
            }

            // if lengths of parts are different, then part with greater length is greater
            if (partLength1 != partLength2)
                return partLength1 - partLength2;
        }

        return tempResult;
    }

    /**
     * Space complexity: O(n + m)
     */
    public int compareVersion2(String version1, String version2) {
        // split to parts
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");

        // loop through parts that exist in both versions
        for (int i = 0; i < Math.min(parts1.length, parts2.length); i++) {
            String part1 = parts1[i], part2 = parts2[i];
            int length1 = part1.length(), length2 = part2.length();
            int pointer1 = 0, pointer2 = 0;

            // remove leading zeros
            while (length1 > 0 && part1.charAt(pointer1) == '0') {
                length1--;
                pointer1++;
            }
            while (length2 > 0 && part2.charAt(pointer2) == '0') {
                length2--;
                pointer2++;
            }

            // after removing leading zeros
            // if one part is greater than another, then this parts is greater
            if (length1 > length2) return 1;
            if (length1 < length2) return -1;

            // lengths are the same
            int length = length1;

            // compare all chars
            for (int j = length - 1; j >= 0; j--) {
                char ch1 = part1.charAt(pointer1), ch2 = part2.charAt(pointer2);

                if (ch1 > ch2) return 1;
                if (ch1 < ch2) return -1;

                pointer1++;
                pointer2++;
            }
        }

        // if versions have the same number of parts, that means they equal
        if (parts1.length == parts2.length) return 0;

        // one version has more parts then another
        // if this version has any non zero character, than it is greater
        if (parts1.length > parts2.length) {
            for (int i = parts2.length; i < parts1.length; i++) {
                for (int j = 0; j < parts1[i].length(); j++) {
                    if (parts1[i].charAt(j) != '0') return 1;
                }
            }
        }
        if (parts1.length < parts2.length) {
            for (int i = parts1.length; i < parts2.length; i++) {
                for (int j = 0; j < parts2[i].length(); j++) {
                    if (parts2[i].charAt(j) != '0') return -1;
                }
            }
        }

        // both versions are equal
        return 0;
    }
}
