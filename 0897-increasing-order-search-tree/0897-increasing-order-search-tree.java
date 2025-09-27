class Solution {
    public TreeNode increasingBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prevNode=new TreeNode(-1);
        TreeNode dummy=prevNode;
        dfs(root,stack);

        while(!stack.isEmpty()){
            TreeNode currNode=stack.pop();
            prevNode.right=currNode;
            currNode.left=null;
            prevNode =currNode;

        }
        return dummy.right;

    }

    void dfs(TreeNode root, Stack<TreeNode> stack) {
        if (root == null) {
            return;
        }
        dfs(root.right, stack);
        stack.push(root);
        dfs(root.left, stack);
        return;
    }
}