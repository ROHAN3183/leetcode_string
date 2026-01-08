class Solution {
    Long[][] dp;

    public long maxAlternatingSum(int[] nums) {
        dp = new Long[nums.length][2];
        return dfs(nums, 0, 1);
    }

    long dfs(int[] nums, int idx, int flag) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][flag] != null) {
            return dp[idx][flag];
        }
        long best = 0;
        if (flag == 1) {
            long take = nums[idx] + dfs(nums, idx + 1, 0);
            long nottake = dfs(nums, idx + 1, 1);
            best = Math.max(take, nottake);
        } else {
            long take = -nums[idx] + dfs(nums, idx + 1, 1);
            long nottake = dfs(nums, idx + 1, 0);
            best = Math.max(take, nottake);
        }
        return dp[idx][flag] = best;
    }
}