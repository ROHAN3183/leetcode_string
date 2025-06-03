class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>>result=new ArrayList<>();
        List<Integer>ans=new ArrayList<>();
        traverse(root,result,ans,targetSum,0);
        return result;
        
    }
    void traverse(TreeNode root,List<List<Integer>>result,List<Integer>ans,int targetSum,int sum){
        if(root==null){
            return;
        }
        sum=sum+root.val;
        ans.add(root.val);
        if(root.left==null && root.right==null && targetSum-sum==0){
            result.add(new ArrayList<>(ans));

        }
        else{
            traverse(root.left,result,ans,targetSum,sum);
            traverse(root.right,result,ans,targetSum,sum);
        }

        ans.remove(ans.size()-1);
    }
}