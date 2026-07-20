public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Boundary check
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Loop continues until they meet (either at the node or at null)
        while (pA != pB) {
            // If pA reaches the end, switch to headB; else move forward
            pA = (pA == null) ? headB : pA.next;
            // If pB reaches the end, switch to headA; else move forward
            pB = (pB == null) ? headA : pB.next;
        }
        
        // Return either the intersection node or null
        return pA;
    }
}