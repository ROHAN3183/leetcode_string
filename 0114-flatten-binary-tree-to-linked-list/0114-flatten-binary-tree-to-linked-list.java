/*logic of the code ->
Alway maintain the lastvisted node so that we can link it with current root. 
do the traversal in the right->left->root.
*/
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
