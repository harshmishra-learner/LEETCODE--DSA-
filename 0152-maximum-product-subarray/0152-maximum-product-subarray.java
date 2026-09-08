class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            // If the current element is negative, swap maxProd and minProd
            if (n < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update running max and min products
            maxProd = Math.max(n, maxProd * n);
            minProd = Math.min(n, minProd * n);

            // Update the overall maximum answer
            result = Math.max(result, maxProd);
        }

        return result;
    }
}