class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[101];
        Arrays.fill(dp, -1);
        return dfs(nums, 0, dp);
    }

    int dfs(int[] nums, int idx, int[] dp) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int first = nums[idx] + dfs(nums, idx + 2, dp);
        int second = 0 + dfs(nums, idx + 1, dp);

        return dp[idx] = Math.max(first, second);
    }
}