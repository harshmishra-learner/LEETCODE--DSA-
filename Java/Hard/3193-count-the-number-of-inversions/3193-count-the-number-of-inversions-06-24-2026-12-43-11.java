import java.util.*;

class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1_000_000_007;
        
        // Map to store requirements: end index -> required inversion count
        Map<Integer, Integer> reqMap = new HashMap<>();
        int maxInversions = 0;
        for (int[] req : requirements) {
            reqMap.put(req[0], req[1]);
            maxInversions = Math.max(maxInversions, req[1]);
        }
        
        // If the base case requirement at index 0 is invalid
        if (reqMap.containsKey(0) && reqMap.get(0) != 0) {
            return 0;
        }
        
        // dp[j] will store the number of valid permutations with 'j' inversions
        long[] dp = new long[maxInversions + 1];
        dp[0] = 1; // Base case: 1 way to have 0 inversions for the 0-th element
        
        // Iterate through each element from index 1 to n-1
        for (int i = 1; i < n; i++) {
            long[] nextDp = new long[maxInversions + 1];
            long windowSum = 0;
            
            // Sliding window to calculate prefix sums for transitions
            for (int j = 0; j <= maxInversions; j++) {
                windowSum = (windowSum + dp[j]) % MOD;
                
                // Keep the window size at most i + 1 (elements that can be shifted)
                if (j > i) {
                    windowSum = (windowSum - dp[j - i - 1] + MOD) % MOD;
                }
                
                nextDp[j] = windowSum;
            }
            
            // If there is a requirement for the current index 'i', enforce it
            if (reqMap.containsKey(i)) {
                int targetInversions = reqMap.get(i);
                long targetWays = nextDp[targetInversions];
                Arrays.fill(nextDp, 0);
                nextDp[targetInversions] = targetWays;
            }
            
            dp = nextDp;
        }
        
        // The answer is the number of ways to form the required inversions at the final index (n - 1)
        return (int) dp[reqMap.get(n - 1)];
    }
}