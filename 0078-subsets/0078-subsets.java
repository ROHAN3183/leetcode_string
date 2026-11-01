class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return result;
    }

    void dfs(int[] nums, int idx, List<Integer> ans) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[idx]);
        dfs(nums, idx + 1, ans);
        ans.remove(ans.size() - 1);
        dfs(nums, idx + 1, ans);
    }
}