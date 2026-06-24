class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Base case: if list is empty or k is 1, no reversal needed
        if (head == null || k == 1) return head;

        // Step 1: Count the total number of nodes
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        // Step 2: Initialize a dummy node to handle head edge cases seamlessly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // prevGroupTail will point to the last node of the previously reversed group
        ListNode prevGroupTail = dummy;

        // Step 3: Process the list in chunks of k
        while (count >= k) {
            // 'curr' is the first node of the current group (which will become the tail)
            curr = prevGroupTail.next; 
            ListNode next = null;
            ListNode prev = null;

            // Standard linked list reversal for exactly k nodes
            for (int i = 0; i < k; i++) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            // Rewire the connections:
            // prevGroupTail.next is the old head of this group (now the tail)
            ListNode tailOfReversedGroup = prevGroupTail.next; 
            
            // Connect the newly formed tail to the rest of the unreversed list
            tailOfReversedGroup.next = curr; 
            
            // Connect the end of the previous group to the new head of this group
            prevGroupTail.next = prev; 
            
            // Move prevGroupTail forward for the next iteration
            prevGroupTail = tailOfReversedGroup; 

            // Decrement the count of remaining nodes
            count -= k;
        }

        // Return the new head of the list
        return dummy.next;
    }
}