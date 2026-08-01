class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 1. Both nodes are null -> Match
        if (p == null && q == null) {
            return true;
        }
        
        // 2. One is null, or values don't match -> Mismatch
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // 3. Check left subtrees and right subtrees recursively
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}