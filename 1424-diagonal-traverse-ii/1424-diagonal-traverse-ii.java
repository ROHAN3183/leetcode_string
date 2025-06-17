class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = nums.size() - 1;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            int m = nums.get(i).size();  
            for (int j = 0; j <= m - 1; j++) {
                int key = i + j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(0,nums.get(i).get(j));
            }
        }
        for(Map.Entry<Integer,List<Integer>>entry:map.entrySet()){
            ans.addAll(entry.getValue());
        }
        int []result=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            result[i]=ans.get(i);
        }
        return result;
    }
}