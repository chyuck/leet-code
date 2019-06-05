package solutions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Solution for https://leetcode.com/problems/merge-k-sorted-lists problem with
 */
public class MergeKSortedLists {

    /**
     * Time complexity: O(N * log(K))
     * Space complexity: O(1)
     * where N - number of nodes, K - number of linked lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        // no nodes
        if (lists == null || lists.length == 0)
            return null;

        // 1 step merge 0,1 2,3 4,5 ... and save to 0,2,4,...
        // 2 step merge 0,2 4,6 ... and save to 0,4,...
        // and continue until all merged to linked list at index 0

        // set intervals like 1,2,4,8,16,...
        for (int interval = 1; interval < lists.length; interval *= 2) {
            // iterate through first linked list
            for (int i = 0; i < lists.length; i += interval * 2) {
                // skip if second list does not exist
                if (i + interval >= lists.length)
                    continue;

                // merge two linked lists
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
        }

        return lists[0];
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create dummy head
        final ListNode result = new ListNode(0);
        // current end of result list
        ListNode currentNode = result;

        // iterate linked lists until one reaches the ned
        while (list1 != null && list2 != null) {
            // take the smallest node and add to result
            if (list1.val < list2.val) {
                currentNode.next = list1;
                currentNode = currentNode.next;

                list1 = list1.next;
                continue;
            }

            currentNode.next = list2;
            currentNode = currentNode.next;

            list2 = list2.next;
        }

        // add leftovers to results
        if (list1 != null) {
            currentNode.next = list1;
            return result.next;
        }

        if (list2 != null) {
            currentNode.next = list2;
        }

        // skip dummy head
        return result.next;
    }

    /**
     * Time complexity: O(N * log(K))
     * Space complexity: O(N)
     * where N - number of nodes, K - number of linked lists
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        // no nodes
        if (lists == null || lists.length == 0)
            return null;

        // add heads of linked lists to min heap
        final PriorityQueue<ListNode> minQueue = new PriorityQueue<>(Comparator.comparingInt(l -> l.val));
        for (int i = 0; i < lists.length; i++) {
            // can be empty linked list
            if (lists[i] != null)
                minQueue.add(lists[i]);
        }

        // create dummy head
        final ListNode result = new ListNode(0);
        // current last node
        ListNode currentNode = result;

        // remove nodes with min value and move to the next node
        while (!minQueue.isEmpty()) {
            // remove nods with min value
            final ListNode node = minQueue.remove();

            // add next node for current linked list
            if (node.next != null)
                minQueue.add(node.next);

            // move to the next node
            currentNode.next = node;
            currentNode = node;
        }

        // exclude dummy head
        return result.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
