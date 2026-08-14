import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        
        // Add all initial elements using the add method
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.add(val);
        
        // Maintain heap size at most k
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        // The root/top of the min-heap is the kth largest element
        return minHeap.peek();
    }
}