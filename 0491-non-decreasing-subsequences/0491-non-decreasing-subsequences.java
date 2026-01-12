class Solution {
    HashMap<List<Integer>, Integer> map;
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        map = new HashMap<>();
        List<List<Integer>>result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(nums, ans, 0);
        for (Map.Entry<List<Integer>, Integer> entry : map.entrySet()) {
            List<Integer> key = entry.getKey();
            result.add(key);
        }
        return result;
    }

    void dfs(int[] nums, List<Integer> ans, int idx) {
        if (ans.size() >= 2 && !map.containsKey(ans)) {
            //result.add(new ArrayList<>(ans));
            map.put(new ArrayList<>(ans), map.getOrDefault(new ArrayList<>(ans), 0) + 1);
        }
        for (int i = idx; i < nums.length; i++) {
            if (ans.isEmpty() || ans.get(ans.size() - 1) <= nums[i]) {
                ans.add(nums[i]);
                dfs(nums, ans, i + 1);
                ans.remove(ans.size() - 1);
            }
        }
        return;
    }
}