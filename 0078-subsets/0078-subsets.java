class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, list);
        return result;
    }

    void dfs(int[] nums, int idx, List<Integer> ans) {
        result.add(new ArrayList<>(ans));

        for (int i = idx; i < nums.length; i++) {
            ans.add(nums[i]);
            dfs(nums, i + 1, ans);
            ans.remove(ans.size() - 1);
        }
        return;
    }
}