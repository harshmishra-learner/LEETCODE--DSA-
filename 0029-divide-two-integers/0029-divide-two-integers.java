class Solution {
    public int divide(int dividend, int divisor) {
        // Special case to prevent 32-bit integer overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative to avoid overflow with abs(Integer.MIN_VALUE)
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Process exponential bit shifts
        while (a <= b) {
            int tempDivisor = b;
            int count = 1;

            // Double the divisor until shifting further would exceed 'a' or overflow
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                count <<= 1;
            }

            a -= tempDivisor;
            quotient += count;
        }

        return isNegative ? -quotient : quotient;
    }
}