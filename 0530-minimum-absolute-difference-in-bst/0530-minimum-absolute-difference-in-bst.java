class Solution {
    public int getMinimumDifference(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        int minVal=Integer.MAX_VALUE;
        dfs(root,list);
        for(int i=0;i<list.size()-1;i++){
            minVal=Math.min(minVal,Math.abs(list.get(i)-list.get(i+1)));

        }
        return minVal;

    }

    void dfs(TreeNode root,List<Integer>list) {
        if (root == null) {
            return ;
        }
        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);

    }

}