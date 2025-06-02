class Solution {
    public int countNodes(TreeNode root) {
       int countTotal= traverse(root);
        return countTotal;
        
    }
    int traverse(TreeNode root){
        if(root==null){
            return 0;
        }
        int number=0;
        int leftTraverseCount=number + traverse(root.left);
        int rightTraverseCount=number + traverse(root.right);
        return leftTraverseCount+rightTraverseCount+1;
    }
}