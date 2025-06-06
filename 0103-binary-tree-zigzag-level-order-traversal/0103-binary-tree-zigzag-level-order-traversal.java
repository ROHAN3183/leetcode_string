class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>result=new ArrayList<>();
        boolean flag=true;
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            List<Integer>ans=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode poped=queue.poll();
                ans.add(poped.val);
                if(flag){
                    if(poped.right!=null){
                        queue.add(poped.right);
                    }
                    if(poped.left!=null){
                        queue.add(poped.left);
                    }
                }
                else if(!flag){
                    if(poped.left!=null){
                        queue.add(poped.left);
                    }
                    if(poped.right!=null){
                        queue.add(poped.right);
                    }
                }

            }
            result.add(ans);
            flag=!flag;
        }
        return result;
    }
}