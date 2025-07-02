class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        dfs(root, target);
        return root;
    }

    void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        dfs(root.left, target);

        if (root.left != null && root.left.val == target && root.left.left == null && root.left.right == null) {
            root.left = null;
        }

        dfs(root.right, target);

        if (root.right != null && root.right.val == target && root.right.right == null && root.right.left == null) {
            root.right = null;
        }

    }
}