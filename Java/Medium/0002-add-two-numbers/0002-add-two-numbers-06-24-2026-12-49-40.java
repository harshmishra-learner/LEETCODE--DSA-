class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head to simplify building the new list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Continue looping as long as there are digits to add OR a carry remains
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry; // Start with the carry from the previous step

            // Add the value from l1 if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next; // Move to the next node
            }

            // Add the value from l2 if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next; // Move to the next node
            }

            // Update the carry for the next iteration
            carry = sum / 10;

            // Create a new node with the single-digit remainder and link it
            current.next = new ListNode(sum % 10);
            current = current.next; // Move our pointer forward
        }

        // The dummy head's next node points to the actual start of our result
        return dummyHead.next;
    }
}