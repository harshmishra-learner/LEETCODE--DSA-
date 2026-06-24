class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Edge case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode current = head;
        
        // Traverse the list until the second-to-last node
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found! Skip the next node
                current.next = current.next.next;
            } else {
                // No duplicate? Safely advance the pointer
                current = current.next;
            }
        }
        
        return head;
    }
}