class Solution {
    public int countNodes(TreeNode root) {
       int countTotal= traverse(root);
        return countTotal;
        
    }
    int traverse(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftTraverseCount=traverse(root.left);
        int rightTraverseCount=traverse(root.right);
        
        return leftTraverseCount+rightTraverseCount+1;
    }
}