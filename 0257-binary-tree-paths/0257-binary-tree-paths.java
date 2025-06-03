class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String>result=new ArrayList<>();
        String ans="";
        traverse(root,result,ans);
        return result;
    }
    void traverse(TreeNode root,List<String>result,String ans){
        if(root==null){
            return;
        }
        ans=ans+root.val;
        
        if(root.left==null && root.right==null){
            result.add(ans);
            return;

        }

        traverse(root.left,result,ans+"->");
        traverse(root.right,result,ans+"->");
        
    }
}