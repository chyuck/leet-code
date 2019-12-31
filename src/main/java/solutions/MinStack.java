package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/min-stack problem with
 * Time complexity: O(1) for all methods
 * Space complexity: O(n)
 */
public class MinStack {

    private class Data {
        public int x;
        public int min;
    };

    private final Stack<Data> stack = new Stack<>();

    private int getMinValue(int x) {
        if (stack.empty()) {
            return x;
        }

        return Math.min(getMin(), x);
    }

    public void push(int x) {
        Data data = new Data();
        data.x = x;
        data.min = getMinValue(x);

        stack.push(data);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        Data data = stack.peek();
        return data.x;
    }

    public int getMin() {
        Data data = stack.peek();
        return data.min;
    }
}
