class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        traversal(root,result);
        return result;
        
    }
    void traversal(TreeNode root,List<Integer>result){
        if(root==null){
            return;
        }
        traversal(root.left,result);
        result.add(root.val);
        traversal(root.right,result);
    }
}