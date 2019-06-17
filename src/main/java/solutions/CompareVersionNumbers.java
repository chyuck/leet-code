package solutions;

/**
 * Solutions for https://leetcode.com/problems/compare-version-numbers problem with
 * Time complexity: O(n)
 * Space complexity: O(1)
 * where n - min length of two versions
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
}
