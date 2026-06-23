public class Solution {
    public int scoreDifference(int[] nums) {
        int score1 = 0, score2 = 0;
        
        // 0 = Player 1, 1 = Player 2
        int activePlayer = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            // Rule 1: odd number
            if (nums[i] % 2 != 0) {
                activePlayer ^= 1; // swap
            }
            
            // Rule 2: every 6th game (index 5,11,...)
            if ((i + 1) % 6 == 0) {
                activePlayer ^= 1; // swap
            }
            
            // Assign score
            if (activePlayer == 0) {
                score1 += nums[i];
            } else {
                score2 += nums[i];
            }
        }
        
        return score1 - score2;
    }
}