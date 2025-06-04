class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode leftTraverse = lowestCommonAncestor(root.left, p, q);
        TreeNode rightTraverse = lowestCommonAncestor(root.right, p, q);

        if (leftTraverse != null && rightTraverse != null)
            return root;
        else if (leftTraverse != null)
            return leftTraverse;
        else
            return rightTraverse;

    }
}