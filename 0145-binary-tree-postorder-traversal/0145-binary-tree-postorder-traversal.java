
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>result=new ArrayList<>();
        traversal(root,result);
        return result;        
    }
    void traversal(TreeNode root,List<Integer>result){
        if(root==null)return;
        traversal(root.left,result);
        traversal(root.right,result);
        result.add(root.val);

    }
}