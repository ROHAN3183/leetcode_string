class Solution {
    int totalSum = 0;
    Integer[][] dp;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        dp = new Integer[n][totalSum];
        if (totalSum % 2 != 0) {
            return false;
        }
        if (dfs(nums, 0, totalSum / 2) == 1) {
            return true;
        }
        return false;
    }

    int dfs(int[] nums, int idx, int target) {
        if (target == 0) {
            return 1;
        }
        if (idx >= nums.length || target < 0) {
            return 0;
        }
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }

        int take = dfs(nums, idx + 1, target - nums[idx]);
        int nottake = dfs(nums, idx + 1, target);

        return dp[idx][target] = Math.max(take, nottake);
    }
}