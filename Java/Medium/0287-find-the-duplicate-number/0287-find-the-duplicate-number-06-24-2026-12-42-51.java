class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Find the intersection point of the two pointers
        int tortoise = nums[0];
        int hare = nums[0];
        
        do {
            tortoise = nums[tortoise];          // Move 1 step
            hare = nums[nums[hare]];            // Move 2 steps
        } while (tortoise != hare);
        
        // Phase 2: Find the entrance to the cycle (the duplicate number)
        tortoise = nums[0];                     // Reset tortoise to start
        while (tortoise != hare) {
            tortoise = nums[tortoise];          // Move 1 step
            hare = nums[hare];                  // Move 1 step
        }
        
        return hare; // or return tortoise;
    }
}