class Solution {
    public int maxAncestorDiff(TreeNode root) {
        List<Integer>result=new ArrayList<>();
        Queue<TreeNode>queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                int maxVal=node.val;
                preOrder(node,maxVal,result);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
        }
        int max=Collections.max(result);
        return max;
        
        
    }

    void preOrder(TreeNode node, int maxVal, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            preOrder(node.left, maxVal, result);
        }
        if (node.right != null) {
            preOrder(node.right, maxVal, result);
        }
        int diff = Math.abs(maxVal- (int)node.val);
        result.add(diff);

    }

}