class Solution {
    public TreeNode invertTree(TreeNode root) {
        return traverse(root);
    }

    TreeNode traverse(TreeNode root) {
        if (root == null) {
            return null;
        }
        swap(root);
        traverse(root.left);
        traverse(root.right);
        return root;
    }

    void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
