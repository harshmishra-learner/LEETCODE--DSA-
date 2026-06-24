
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Count total nodes in the list
        int totalNodes = 0;
        ListNode curr = head;
        while (curr != null) {
            totalNodes++;
            curr = curr.next;
        }

        // Dummy node helps manage changes to the head seamlessly
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 2. Iterative bottom-up merge sort
        // Step size doubles each time: 1, 2, 4, 8... up to totalNodes
        for (int step = 1; step < totalNodes; step *= 2) {
            ListNode prev = dummy;
            curr = dummy.next;

            while (curr != null) {
                // Extract the first sub-list of size 'step'
                ListNode left = curr;
                ListNode right = split(left, step);
                
                // Extract the next chunk of the list to process later
                curr = split(right, step);

                // Merge the two chunks and link them back to the chain
                prev.next = merge(left, right);
                
                // Move 'prev' to the end of the newly merged chunk
                while (prev.next != null) {
                    prev = prev.next;
                }
            }
        }

        return dummy.next;
    }

    /**
     * Splits off a sub-list of size 'size' from 'head'.
     * Returns the head of the REMAINING list.
     */
    private ListNode split(ListNode head, int size) {
        if (head == null) return null;

        // Move 'size - 1' steps forward
        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }

        // Cut the link and return the rest of the list
        ListNode remaining = head.next;
        head.next = null;
        return remaining;
    }

    /**
     * Standard iterative merge function for two sorted lists.
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}