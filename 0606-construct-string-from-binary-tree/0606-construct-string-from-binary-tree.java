
class Solution {
    public String tree2str(TreeNode root) {
        StringBuilder res = new StringBuilder();
        traverse(root, res);
        return res.toString();

    }

    void traverse(TreeNode root, StringBuilder res) {
        if (root == null) {
            return;
        }
        res = res.append(Integer.toString(root.val));
        if (root.left != null) {
            res.append("(");
            traverse(root.left, res);
            res.append(")");
        } else if (root.right != null) {
            res.append("()");
        }
        if (root.right != null) {
            res.append("(");
            traverse(root.right, res);
            res.append(")");

        }
    }
}