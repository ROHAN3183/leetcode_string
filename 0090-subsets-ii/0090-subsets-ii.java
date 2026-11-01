class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, list, 0);
        return result;
    }

    void dfs(int[] nums, List<Integer> list, int idx) {
        result.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            dfs(nums, list, i + 1);
            list.remove(list.size() - 1);

        }
    }
}