import java.util.HashMap;
import java.util.Map;

class LRUCache {

    // Node structure for Doubly Linked List
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // Dummy head (MRU side)
    private final Node tail; // Dummy tail (LRU side)

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Initialize dummy head and tail to avoid boundary null checks
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        // Move accessed node to head (most recently used)
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update value and move node to head
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // If cache is full, evict LRU item
            if (map.size() == capacity) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }

            // Create new node, insert into HashMap, and place at head
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNodeToHead(newNode);
        }
    }

    // Helper method to remove a node from Doubly Linked List
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper method to insert a node right after the dummy head
    private void addNodeToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Move an existing node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addNodeToHead(node);
    }
}