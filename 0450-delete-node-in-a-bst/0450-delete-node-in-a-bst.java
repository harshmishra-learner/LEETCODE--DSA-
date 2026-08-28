class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 1. Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // 2. Node found — handle the 3 deletion cases
            
            // Case 1 & Case 2: One or no children
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Case 3: Two children
            // Find in-order successor (minimum value in right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val; // Copy successor value to current node
            root.right = deleteNode(root.right, successor.val); // Delete the successor
        }

        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}