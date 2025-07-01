class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode newroot=new TreeNode(val);
            newroot.left=root;
            return newroot;

        }
        return bfs(root,val,depth);
        
    }
    TreeNode bfs(TreeNode root,int val,int depth){
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(root);
        int level=1;
        while(level<=depth){
            int size=queue.size();
            if(depth-1==level){
                for(int i=0;i<size;i++){

                    TreeNode node=queue.poll();

                   TreeNode newnodeleft=new TreeNode(val);
                   newnodeleft.left=node.left;
                   node.left=newnodeleft;
                   
                   TreeNode newnoderight=new TreeNode(val);
                   newnoderight.right=node.right;
                   node.right=newnoderight;

                }
                break;

            }
            else{
                for(int i=0;i<size;i++){
                    TreeNode node=queue.poll();
                    if(node.left!=null){
                        queue.add(node.left);
                    }
                    if(node.right!=null){
                        queue.add(node.right);
                    }
                }
            }
            level++;
        }
        return root;
    }
}