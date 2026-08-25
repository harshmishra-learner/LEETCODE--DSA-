class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        // Step 1: Find length and tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        // Step 2: Form a circular list
        tail.next = head;
        
        // Step 3: Find the new tail position
        int effectiveK = k % length;
        int stepsToNewTail = length - effectiveK;
        
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }
        
        // Step 4: Break the circle and update new head
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
}