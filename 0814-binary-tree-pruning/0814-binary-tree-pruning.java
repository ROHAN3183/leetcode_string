class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }
    TreeNode dfs(TreeNode root){
        if(root==null){
            return null;
        }
        root.left=dfs(root.left);
        root.right=dfs(root.right);
        if(root.left==null && root.right==null){
            if(root.val!=1){
                return null;
            }

        }
        return root;
    }
}