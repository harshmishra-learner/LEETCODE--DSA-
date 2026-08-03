class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for (int i = n - 1; i >= 0; i--) {
            // Case 1 & 2: Digit is less than 9
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Case 3: Digit is 9, turn to 0 and carry over 1 to the next iteration
            digits[i] = 0;
        }

        // Case 4: All digits were 9 (e.g., [9, 9] -> [1, 0, 0])
        int[] result = new int[n + 1];
        result[0] = 1; // Default array values in Java are 0
        return result;
    }
}