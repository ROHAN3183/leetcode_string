
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>list=new ArrayList<>();
         if (root == null) return list;
        queue.add(root);
        while(!queue.isEmpty()){
             List<Integer>ans=new ArrayList<>();
            int n=queue.size();
            for(int i=0;i<n;i++){
               
                TreeNode node=queue.poll();
                ans.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(ans);
            
        }
        return list;
        
    }
}