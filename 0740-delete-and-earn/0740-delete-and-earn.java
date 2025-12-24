class Solution {
    Integer [] dp;
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int val : nums) {
            map.put(val, map.getOrDefault(val, 0) + 1);
            set.add(val);
        }

        List<Integer> list = new ArrayList<>(set);
        dp = new Integer[list.size()];
        Collections.sort(list);
        return dfs(list, map, 0);
    }

    int dfs(List<Integer> list, Map<Integer, Integer> map, int idx) {
        if (idx >= list.size()) {
            return 0;
        }
        if(dp[idx]!=null){
            return dp[idx];
        }

        int take = 0;
        int nottake = 0;

        if ((idx + 1 < list.size()) && (list.get(idx) + 1 == list.get(idx + 1))) {
            take = map.get(list.get(idx)) * list.get(idx) + dfs(list, map, idx + 2);
        } else {
            take = map.get(list.get(idx)) * list.get(idx) + dfs(list, map, idx + 1);
        }

        nottake = dfs(list, map, idx + 1);

        return dp[idx]=Math.max(take, nottake);
    }
}