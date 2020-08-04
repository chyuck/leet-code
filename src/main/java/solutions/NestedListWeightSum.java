package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution for https://leetcode.com/problems/nested-list-weight-sum/ problem with
 * Time complexity: O(N + K), where N - total numbers, K - total nested lists
 * Space complexity: O(k), where k max depth
 */
public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private static int depthSum(List<NestedInteger> nestedList, int depth) {
        int result = 0;

        for (NestedInteger ni : nestedList) {
            result += depthSum(ni, depth);
        }

        return result;
    }

    private static int depthSum(NestedInteger ni, int depth) {
        return ni.isInteger() ? ni.getInteger() * depth : depthSum(ni.getList(), depth + 1);
    }

    static class NestedInteger {
        private List<NestedInteger> list;
        private Integer value;

        /**
         * Constructor initializes an empty nested list.
         */
        public NestedInteger() {
            this.list = new ArrayList<>();
            this.value = null;
        }

        public NestedInteger(List<NestedInteger> list) {
            this.list = list;
            this.value = null;
        }

        /**
         * Constructor initializes a single integer.
         */
        public NestedInteger(int value) {
            this.list = null;
            this.value = value;
        }

        /**
         * @return true if this NestedInteger holds a single integer, rather than a nested list.
         */
        public boolean isInteger() {
            return this.value != null;
        }

        /**
         * @return the single integer that this NestedInteger holds, if it holds a single integer.
         * Return null if this NestedInteger holds a nested list
         */
        public Integer getInteger() {
            return this.value;
        }

        /**
         * Set this NestedInteger to hold a single integer.
         */
        public void setInteger(int value) {
            this.list = null;
            this.value = value;
        }

        /**
         * Set this NestedInteger to hold a nested list and adds a nested integer to it.
         */
        public void add(NestedInteger ni) {
            this.list = Arrays.asList(ni);
            this.value = null;
        }

        /**
         * @return the nested list that this NestedInteger holds, if it holds a nested list.
         * Return null if this NestedInteger holds a single integer
         */
        public List<NestedInteger> getList() {
            return this.list;
        }
    }
}
