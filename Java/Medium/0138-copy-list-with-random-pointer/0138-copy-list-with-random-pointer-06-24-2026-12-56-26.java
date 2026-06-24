class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Clone nodes and interweave them with the original list
        Node curr = head;
        while (curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next; // Move to the next original node
        }

        // Step 2: Assign random pointers for the cloned nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                // The clone's random pointer should point to the clone of the original's random node
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next; // Move to the next original node
        }

        // Step 3: Unweave the combined list to extract the deep copy
        curr = head;
        Node dummyHead = new Node(0); // Dummy node to help build the cloned list
        Node cloneCurr = dummyHead;

        while (curr != null) {
            // Extract the cloned node
            cloneCurr.next = curr.next;
            cloneCurr = cloneCurr.next;
            
            // Restore the original list
            curr.next = curr.next.next;
            curr = curr.next;
        }

        return dummyHead.next; // Return the head of the cloned list
    }
}