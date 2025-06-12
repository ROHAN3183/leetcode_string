class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        int min = -(int)Math.pow(10,5);
        int level=1;
        int index=1;
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            int sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                sum=sum+node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            if(min<sum){
                min=sum;
                level=index;
            }
            index++;


        }
        return level;
        
    }
}