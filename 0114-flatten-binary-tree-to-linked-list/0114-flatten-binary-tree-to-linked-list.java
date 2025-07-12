class Solution {
    TreeNode lastVisited;

    public void flatten(TreeNode root) {
        lastVisited = null;
        postorder(root);

    }

    void postorder(TreeNode root) {
        if (root == null) {
            return;
        }

        postorder(root.right);
        postorder(root.left);

        root.left = null;
        root.right = lastVisited;

        lastVisited = root;
    }
}