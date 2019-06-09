package solutions;

/**
 * Solutions for https://leetcode.com/problems/add-two-numbers problem with
 * Time complexity: O(max(m,n))
 * Space complexity: O(max(m,n))
 * where m, n - lengths of input numbers
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if onr of the number is null, return another one
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        // create results head pointer with dummy node
        final ListNode results = new ListNode(0);
        // create and point results pointer to the head
        ListNode resultsPointer = results;

        // value to keep reminder from previous sum operation
        int carry = 0;

        // iterate numbers until we process both completely
        while (l1 != null || l2 != null) {
            // one of the numbers can be longer, that's why adding zeros to shorter number
            final int digit1 = l1 != null ? l1.val : 0;
            final int digit2 = l2 != null ? l2.val : 0;
            // just simple math https://en.wikipedia.org/wiki/Carry_(arithmetic)
            final int sum =  digit1 + digit2 + carry;
            final int result = sum % 10;
            carry = sum / 10;

            // save result in results list
            resultsPointer.next = new ListNode(result);
            resultsPointer = resultsPointer.next;

            // move numbers to the next digits, if number has more digits
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // if there is carry left, just add it to result
        if (carry > 0) {
            resultsPointer.next = new ListNode(carry);
        }

        // remove first dummy node
        return results.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) { this.val = val; }

        public ListNode(int val, ListNode next) {
            this(val);
            this.next = next;
        }

        @Override
        public String toString() {
            return Integer.toString(this.val);
        }
    }
}