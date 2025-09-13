class Solution {
    HashMap<String, Integer> map;

    public int findTargetSumWays(int[] nums, int target) {
        map = new HashMap<>();
        return dfs(nums, target, 0, 0);
    }

    int dfs(int[] nums, int target, int sum, int idx) {
        if (idx == nums.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }
        String temp = sum + "," + idx;
        if (map.containsKey(temp)) {
            return map.get(temp);
        }
        int take_positive = dfs(nums, target, sum + nums[idx], idx + 1);
        int take_negative = dfs(nums, target, sum - nums[idx], idx + 1);

        int result = take_positive + take_negative;
        map.put(temp, result);
        return result;

    }
}