class Solution {
    public ListNode sortList(ListNode head) {
        // Base case: if list is empty or has only one node, it's already sorted
        if (head == null || head.next == null) {
            return head;
        }
        
        // Step 1: Split the list into two halves
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Disconnect the first half from the second half
        prev.next = null;
        
        // Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        
        // Step 3: Merge the sorted halves
        return merge(left, right);
    }
    
    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        // Append any remaining nodes
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }
        
        return dummy.next;
    }
}