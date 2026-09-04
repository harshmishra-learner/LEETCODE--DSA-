class Solution {
    public double myPow(double x, int n) {
        long N = n; // Use long to prevent integer overflow when n = Integer.MIN_VALUE
        
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double ans = 1.0;
        double currentProduct = x;
        
        while (N > 0) {
            // If N is odd, multiply the current base to the answer
            if (N % 2 == 1) {
                ans *= currentProduct;
            }
            // Square the base and halve the power
            currentProduct *= currentProduct;
            N /= 2;
        }
        
        return ans;
    }
}