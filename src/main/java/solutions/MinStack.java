package solutions;

import java.util.Stack;

/**
 * Solution for https://leetcode.com/problems/min-stack problem with
 * Time complexity: O(1) for all methods
 * Space complexity: O(n)
 */
public class MinStack {

    private class Node {
        public int value;
        // top node will keep min value of stack
        public int minValue;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }

    private final Stack<Node> stack = new Stack<>();

    public void push(int x) {
        int minValue = getMinValue(x);

        Node node = new Node(x, minValue);
        stack.push(node);
    }

    private int getMinValue(int x) {
        if (stack.isEmpty())
            return x;

        Node topNode = stack.peek();
        return Math.min(topNode.minValue, x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        Node topNode = stack.peek();
        return topNode.value;
    }

    public int getMin() {
        Node topNode = stack.peek();
        return topNode.minValue;
    }
}
