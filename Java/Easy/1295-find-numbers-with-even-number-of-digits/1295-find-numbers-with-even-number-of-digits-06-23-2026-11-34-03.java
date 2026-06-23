class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        if (nums.length != 0) {
            String strnum;
            for (int i = 0; i < nums.length; i++) {
                strnum = Integer.toString(nums[i]);
                if (strnum.length() % 2 == 0)
                    count++;

            }
        }
        return count;
    }
}