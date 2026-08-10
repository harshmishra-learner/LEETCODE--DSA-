import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            // If duplicate found within window size k
            if (set.contains(nums[i])) {
                return true;
            }
            
            set.add(nums[i]);
            
            // Maintain sliding window size of k
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        
        return false;
    }
}