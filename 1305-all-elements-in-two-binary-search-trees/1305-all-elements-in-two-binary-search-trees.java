class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {

        List<Integer>result=new ArrayList<>();
        List<Integer>list1=new ArrayList<>();
        List<Integer>list2=new ArrayList<>();

        dfs(root1,list1);
        dfs(root2,list2);

        int i=0;
        int j=0;
        while(i<list1.size() && j<list2.size()){

            if(list1.get(i)<=list2.get(j)){
                result.add(list1.get(i));
                i++;
            }
            else{
                result.add(list2.get(j));
                j++;
            }
        }
        if(i>=list1.size() && j>=list2.size()){
            return result;
        }

        if(i>=list1.size() && j<list2.size()){
            result.addAll(list2.subList(j,list2.size()));
        }
        else{
            result.addAll(list1.subList(i,list1.size()));
        }

        return result;
    }

    void dfs(TreeNode root,List<Integer>list){
        if(root==null){
            return ;
        }

        dfs(root.left,list);
        list.add(root.val);
        dfs(root.right,list);

        return;
    }
}