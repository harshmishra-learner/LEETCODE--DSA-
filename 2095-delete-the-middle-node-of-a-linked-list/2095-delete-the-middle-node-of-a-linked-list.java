class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Base case: 0 or 1 node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Fast pointer moves 2x faster than slow pointer
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Delete the middle node by skipping it
        prev.next = slow.next;

        return head;
    }
}