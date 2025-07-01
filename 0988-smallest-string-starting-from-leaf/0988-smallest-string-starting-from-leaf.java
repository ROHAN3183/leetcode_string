//Java, whenever you want to compare strings lexicographically (dictionary order), you should use:
//👉 compareTo() or compareToIgnoreCase()

class Solution {
    String result = "";

    public String smallestFromLeaf(TreeNode root) {
        StringBuilder ans = new StringBuilder();
        dfs(root, ans);
        return result;
    }

    void dfs(TreeNode root, StringBuilder ans) {
        if (root == null) {
            return;
        }
        ans.insert(0, (char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            if (result == "" || ans.toString().compareTo(result) < 0) {
                result = ans.toString();
            }
        }
        dfs(root.left, ans);
        dfs(root.right, ans);
        ans.deleteCharAt(0);
    }
}
