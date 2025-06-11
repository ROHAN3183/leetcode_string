class Solution {
    int minValue=(int)Math.pow(10,5);
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        traverse(root,0);
        return minValue;

        
    }
    void traverse(TreeNode root,int level){
        if(root==null){
            minValue=Math.min(minValue,level);
            return;
        }
        traverse(root.left,level+1);
        traverse(root.right,level+1);


    }
}