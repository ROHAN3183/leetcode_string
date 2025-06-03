class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        sideView(root,result,1);
        return result;
        
    }
    void sideView(TreeNode root,List<Integer>result,int level){
        if(root==null){
            return;
        }
        if(result.size()<level){
            result.add(root.val);

        }
        sideView(root.right,result,level+1);
        sideView(root.left,result,level+1);

    }
}