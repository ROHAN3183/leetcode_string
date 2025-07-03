class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        TreeNode left, right;

        if (root1 != null && root2 != null) {
            left = dfs(root1.left, root2.left);
            right = dfs(root1.right, root2.right);
            root1.val = root1.val + root2.val;
            root1.left = left;
            root1.right = right;
            return root1;
        } else if (root1 != null) {
            left = dfs(root1.left, null);
            right = dfs(root1.right, null);
            root1.left = left;
            root1.right = right;
            return root1;
        } else {
            left = dfs(null, root2.left);
            right = dfs(null, root2.right);
            root2.left = left;
            root2.right = right;
            return root2;
        }
    }
}
