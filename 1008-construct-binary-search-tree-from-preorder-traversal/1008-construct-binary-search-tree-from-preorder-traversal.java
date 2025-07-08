class Solution {
    int idx = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        int maxValue = Integer.MAX_VALUE;
        return dfs(preorder, maxValue);
    }

    TreeNode dfs(int[] preorder, int max) {
        if (idx >= preorder.length || preorder[idx] > max) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);

        root.left = dfs(preorder, root.val);

        root.right = dfs(preorder, max);
        return root;
    }
}