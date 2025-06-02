
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root);
        
    }
    int diameter(TreeNode root){
        if(root==null)return 0;
        int leftDiameter=diameter(root.left);
        int rightDiameter=diameter(root.right);
        int rootDiameter=height(root.left)+height(root.right);
        return Math.max(leftDiameter,Math.max(rightDiameter,rootDiameter));

    }
    int height(TreeNode root){
        if(root==null)return 0;
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);

        return Math.max(leftHeight,rightHeight)+1;
    }
}