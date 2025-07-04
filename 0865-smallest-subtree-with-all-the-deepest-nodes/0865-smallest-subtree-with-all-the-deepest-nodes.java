class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Object[] result = dfs(root, 0);
        return (TreeNode) result[0];

    }

    Object[] dfs(TreeNode root, int depth) {
        if (root == null) {
            return new Object[] { null, depth - 1 };
        }
        if (root.left == null && root.right == null) {
            return new Object[] { root, depth };
        }
        Object[] left = dfs(root.left, depth + 1);
        Object[] right = dfs(root.right, depth + 1);

        int leftdepth = (int) left[1];
        int rightdepth = (int) right[1];

        if (leftdepth == rightdepth) {
            return new Object[] { root, leftdepth };
        } else if (leftdepth > rightdepth) {
            return left;
        } else {
            return right;
        }

    }
}