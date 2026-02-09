class Solution {
    public boolean isValidBST(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        
    }
    boolean dfs(TreeNode root,int min,int max){
        if(root==null){
            return true;
        }
        if(root.val>=max || root.val<=min){
            return false;
        }
        return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
    }
}