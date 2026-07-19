class Solution {
    public boolean isPowerOfTwo(int n) {
        // n must be greater than 0, and isolating the rightmost 1-bit must equal n
        return n > 0 && (n & -n) == n;
    }
}