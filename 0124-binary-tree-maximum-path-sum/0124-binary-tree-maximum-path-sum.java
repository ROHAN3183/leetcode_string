class Solution {
    public int maxPathSum(TreeNode root) {
        int[] result = dfs(root);
        return result[1];
    }

    int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, Integer.MIN_VALUE };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int leftGain = Math.max(0, left[0]);
        int rightGain = Math.max(0, right[0]);

        int maxDown = root.val + Math.max(leftGain, rightGain);

        int throughRoot = root.val + leftGain + rightGain;

        int maxPath = Math.max(
            throughRoot,
            Math.max(left[1], right[1])
        );

        return new int[] { maxDown, maxPath };
    }
}