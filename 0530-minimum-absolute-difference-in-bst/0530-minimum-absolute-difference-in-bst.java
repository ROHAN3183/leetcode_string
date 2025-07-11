class Solution {
    int minVal=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        
        dfs(root);
        return minVal;
    }
    int dfs(TreeNode root){
        if(root==null){
            //base-case
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        int leftDiff=Math.abs(root.val-left);
        int rightDiff=Math.abs(root.val-right);
        int difference=Math.min(leftDiff,rightDiff);
        minVal=Math.min(minVal,difference);
        return root.val;
    }
}