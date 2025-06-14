class Solution {
    int maxLevel = 0;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findLevel(root, 0);
        TreeNode result = lca(root, 0);
        return result;

    }

    void findLevel(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        maxLevel = Math.max(maxLevel, level);
        findLevel(root.left, level + 1);
        findLevel(root.right, level + 1);

    }

    TreeNode lca(TreeNode root, int level) {
        if (root == null) {
            return null;
        }
        if (level == maxLevel) {
            return root;
        }
        TreeNode lefttraverse = lca(root.left, level + 1);
        TreeNode righttraverse = lca(root.right, level + 1);

        if (lefttraverse != null && righttraverse != null) {
            return root;
        }
        if (lefttraverse != null) {
            return lefttraverse;
        } else {
            return righttraverse;
        }

    }
}