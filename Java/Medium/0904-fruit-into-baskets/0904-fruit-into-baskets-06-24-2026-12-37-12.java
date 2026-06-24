class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        
        // Find the maximum fruit ID to size our frequency array dynamically
        int maxFruitId = 0;
        for (int fruit : fruits) {
            if (fruit > maxFruitId) maxFruitId = fruit;
        }
        
        // Use a primitive array instead of a HashMap
        int[] count = new int[maxFruitId + 1];
        
        int L = 0, R = 0, maxLen = 0;
        int distinctFruits = 0;
        
        while (R < n) {
            // Add fruit to window
            if (count[fruits[R]] == 0) {
                distinctFruits++;
            }
            count[fruits[R]]++;
            
            // Shrink window if we have more than 2 types of fruits
            if (distinctFruits > 2) {
                count[fruits[L]]--;
                if (count[fruits[L]] == 0) {
                    distinctFruits--;
                }
                L++;
            }
            
            if (distinctFruits <= 2) {
                maxLen = Math.max(maxLen, R - L + 1);
            }
            R++;
        }
        return maxLen;
    }
}