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
class Solution {
    public ListNode middleNode(ListNode head) {
        // Initialize both pointers at the head of the list
        ListNode slow = head;
        ListNode fast = head;
        
        // Move fast by two steps and slow by one step
        // Ensure fast and fast.next are not null to avoid NullPointerException
        while (fast != null && fast.next != null) {
            slow = slow.next;       // Shift 1 step
            fast = fast.next.next;  // Shift 2 steps
        }
        
        // When fast reaches the end, slow is at the middle
        return slow;
    }
}