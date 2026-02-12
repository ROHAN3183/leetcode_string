
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        StringBuilder str = new StringBuilder();
        return dfs(root, str);
    }

    int dfs(TreeNode root, StringBuilder str) {
        if (root.left == null && root.right == null) {
            str.append(root.val);
            String s = str.toString();
            int ans = Integer.parseInt(s, 2);
            str.deleteCharAt(str.length() - 1);
            return ans;
        }
        str.append(root.val);

        int left = dfs(root.left, str);
        int right = dfs(root.right, str);

        str.deleteCharAt(str.length() - 1);

        return left + right;
    }
}