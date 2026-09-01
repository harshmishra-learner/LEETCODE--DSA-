class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder, Integer.MAX_VALUE);
    }

    private TreeNode build(int[] preorder, int bound) {
        // Base case: out of bounds or value exceeds current subtree max limit
        if (index >= preorder.length || preorder[index] > bound) {
            return null;
        }

        // Create the root node for this subtree
        TreeNode root = new TreeNode(preorder[index++]);

        // Values for the left subtree must be < root.val
        root.left = build(preorder, root.val);

        // Values for the right subtree must be < outer bound
        root.right = build(preorder, bound);

        return root;
    }
}