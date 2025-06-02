class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return traverse(root,subRoot);
    }
    boolean traverse(TreeNode root,TreeNode subRoot){
        if(root==null)return false;
        if(isSame(root,subRoot)){
            return true;
        }
        return traverse(root.left,subRoot)||traverse(root.right,subRoot);

    }
    boolean isSame(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null||subRoot==null){
            return false;
        }
        if(root.val!=subRoot.val){
            return false;

        }
        return isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }
    

}