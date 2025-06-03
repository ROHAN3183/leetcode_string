class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
    
        return leftSum(root);
        
    }
    int leftSum(TreeNode root){
        if(root==null)return 0;
        int sum=0;
        if(root.left!=null&&root.left.left==null && root.left.right==null){
            sum+=root.left.val;
        }

        sum += leftSum(root.left);
        sum+=leftSum(root.right);

        return sum;
    }
}