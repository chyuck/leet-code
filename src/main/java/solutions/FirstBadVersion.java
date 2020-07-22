package solutions;

/**
 * Solution for https://leetcode.com/problems/first-bad-version/ problem with
 * Time complexity: O(log(n))
 * Space complexity: O(1)
 */
public class FirstBadVersion extends VersionControl {

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;

        while (start < end) {
            int middle = start + (end - start) / 2;

            if (isBadVersion(middle)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return start;
    }

    public FirstBadVersion(int firstBadVersion) {
        super(firstBadVersion);
    }
}

class VersionControl {
    private final int firstBadVersion;

    VersionControl(int firstBadVersion) {
        this.firstBadVersion = firstBadVersion;
    }

    boolean isBadVersion(int version) {
        return version >= firstBadVersion;
    }
}
