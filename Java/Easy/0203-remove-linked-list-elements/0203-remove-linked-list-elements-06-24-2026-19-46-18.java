class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Instantiate a dummy node to seamlessly handle head deletion edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode curr = dummy;
        
        // Look ahead to evaluate the next node's value
        while (curr.next != null) {
            if (curr.next.val == val) {
                // Bypass/delete the target node
                curr.next = curr.next.next;
            } else {
                // Only advance if we didn't delete a node
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}