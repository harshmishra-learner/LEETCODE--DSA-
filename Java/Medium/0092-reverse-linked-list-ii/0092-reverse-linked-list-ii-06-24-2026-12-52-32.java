/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Edge case: If the list is empty or no reversal is needed, exit early
        if (head == null || left == right) return head;

        // 1. Setup a dummy node to seamlessly handle reversing from the actual head (position 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 2. Reach the node right BEFORE the sub-list reversal zone
        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 3. Initialize pointers for the reversal zone
        ListNode current = prev.next; // The first node to be shifted (sub-list head)
        
        // 4. In-place reversal loop
        for (int i = 0; i < right - left; i++) {
            ListNode nodeToMove = current.next; // The node we want to jump to the front
            
            // Disconnect nodeToMove and bridge current to the node after it
            current.next = nodeToMove.next;
            
            // Splice nodeToMove into its new home right after 'prev'
            nodeToMove.next = prev.next;
            prev.next = nodeToMove;
        }

        // 5. Return the updated head pointer via dummy.next
        return dummy.next;
    }
}