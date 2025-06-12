class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long>list=new ArrayList<>();
        HashMap<Integer,Long>map=new HashMap<>();
        traverse(root,1,map);
        for(Map.Entry<Integer,Long>entry:map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list,Collections.reverseOrder());
        if (k > list.size()) return -1;
        Long result=list.get(k-1);
        return result;
        
    }
    void traverse(TreeNode root,int level,HashMap<Integer,Long>map){
        if(root==null){
            return;
        }
        if(map.containsKey(level)){
            long oldValue=map.get(level);
            map.put(level,oldValue+root.val);
        }
        else{
            map.put(level,(long)root.val);
        }

        traverse(root.left,level+1,map);
        traverse(root.right,level+1,map);
    }
}