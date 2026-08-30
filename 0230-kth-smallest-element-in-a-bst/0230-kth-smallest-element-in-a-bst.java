class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            // Push all left children to stack
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            // Process node
            curr = stack.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            
            // Move to right subtree
            curr = curr.right;
        }
        
        return -1;
    }
}