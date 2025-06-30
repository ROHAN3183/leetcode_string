class Solution {
    int pos = 1;  

    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = inorder(root, k);
        return node.val;
    }

    TreeNode inorder(TreeNode root, int k) {
        if (root == null) {
            return null;
        }

        TreeNode left = inorder(root.left, k);
        if (left != null) return left; 

        
        if (pos == k) {
            return root;
        }
        pos++;

        TreeNode right = inorder(root.right, k);
        if (right != null) return right; 

        return null;
    }    
}
