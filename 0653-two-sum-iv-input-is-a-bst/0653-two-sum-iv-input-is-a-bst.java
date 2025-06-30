class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return inorder(root, root, k);
    }

    // Traverse each node and check if its complement exists in the tree (excluding itself)
    boolean inorder(TreeNode node, TreeNode root, int k) {
        if (node == null) {
            return false;
        }

        int target = k - node.val;

        // ✅ Look for complement in the tree, ensuring we don't use the same node
        if (found(root, target, node)) {
            return true;
        }

        // ✅ Recurse on left and right subtrees
        return inorder(node.left, root, k) || inorder(node.right, root, k);
    }

    // Search for target in BST, but ignore the original node
    boolean found(TreeNode root, int target, TreeNode exclude) {
        if (root == null) {
            return false;
        }

        if (root.val == target && root != exclude) {
            return true;
        }

        if (target < root.val) {
            return found(root.left, target, exclude);
        } else {
            return found(root.right, target, exclude);
        }
    }
}
