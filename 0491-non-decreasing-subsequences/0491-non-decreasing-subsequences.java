class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        dfs(nums, ans, 0);
        return result;
    }

    void dfs(int[] nums, List<Integer> ans, int idx) {
        if (ans.size() >= 2) {
            result.add(new ArrayList<>(ans));
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