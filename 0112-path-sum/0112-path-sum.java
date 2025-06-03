class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root,targetSum,0);
        
    }
    boolean traverse(TreeNode root,int targetSum,int sum){
        if(root==null){
            return false;
        }
        sum=sum+root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        return traverse(root.left,targetSum,sum)||traverse(root.right,targetSum,sum);
    
    }
}