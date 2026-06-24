class Solution {
    public int pivotIndex(int[] nums) {
        int total=0,left=0,right=0;
        for(int i=0;i<nums.length;i++)total=total+nums[i];
        for(int i=0;i<nums.length;i++){
         
            
            right=total-left-nums[i];
            if(left==right)return i;
             left=left+nums[i];
              
            
        }
       return -1;
    }
}