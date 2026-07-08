/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        
        while (low < high) {
            // Prevents integer overflow
            int mid = low + (high - low) / 2; 
            
            if (isBadVersion(mid)) {
                // Look left, but include mid because it might be the first bad one
                high = mid; 
            } else {
                // Look strictly right
                low = mid + 1; 
            }
        }
        
        // low and high converge to the first bad version
        return low; 
    }
}