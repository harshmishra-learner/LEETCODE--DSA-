class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructBST(int[] nums, int start, int end) {
        // Base case: if start index crosses end index, subarray is empty
        if (start > end) {
            return null;
        }
        
        // Calculate the middle element to prevent potential integer overflow
        int mid = start + (end - start) / 2;
        
        // Create the root node with the middle value
        TreeNode root = new TreeNode(nums[mid]);
        
        // Recursively build the left and right subtrees
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        
        return root;
    }
}