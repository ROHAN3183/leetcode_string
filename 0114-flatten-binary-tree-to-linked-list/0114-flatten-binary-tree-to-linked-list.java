class Solution {
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return;
        }

        dfs(root);
        root.left=null;

        for(int i=1;i<list.size();i++){
            root.right=list.get(i);
            root.left=null;
            root=list.get(i);
        }
        return;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        list.add(root);

        dfs(root.left);
        dfs(root.right);

        return;
    }
}