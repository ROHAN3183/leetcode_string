class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer>map=new HashMap<>();
        List<TreeNode>result=new ArrayList<>();
        String ans="";
        Traverse(root,map,ans,result);
        return result;

    }

    String Traverse(TreeNode root,HashMap<String,Integer>map,String ans,List<TreeNode>result){
        if(root==null){
            return "$";
        }
        String left=Traverse(root.left,map,ans,result);
        String right=Traverse(root.right,map,ans,result);
        ans=ans+(left+","+right+","+Integer.toString(root.val)+",");
        map.put(ans,map.getOrDefault(ans,0)+1);
        if(map.get(ans)==2){
            result.add(root);
        }
        return ans;

    }
}