class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return dfs(root,target);
    }
    TreeNode dfs(TreeNode root,int target){
        if(root==null){
            return null;
        }
        root.left=dfs(root.left,target);
        root.right=dfs(root.right,target);
        if(root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;

    }
}