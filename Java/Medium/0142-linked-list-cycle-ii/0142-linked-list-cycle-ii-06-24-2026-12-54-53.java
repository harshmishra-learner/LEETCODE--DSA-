/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Step 1: Detect if a cycle is present
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            // A cycle is found
            if (slow == fast) {
                ListNode entry = head;
                
                // Step 2: Find the entry point of the cycle
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        
        return null;
    }
}