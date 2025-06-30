class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return inorder(root,p,q);
    }
    TreeNode inorder(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return null;
        }
        if(root.val<p.val &&root.val<q.val){
            return inorder(root.right,p,q);
        }
        else if(root.val>p.val && root.val>q.val){
            return inorder(root.left,p,q);
        }

        return root;
    }
}