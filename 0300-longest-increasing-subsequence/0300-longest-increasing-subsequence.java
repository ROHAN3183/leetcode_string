class Solution {
    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n + 1];
        return dfs(nums, 0, -1);
    }

    int dfs(int[] nums, int idx, int prev) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][prev + 1] != null) {
            return dp[idx][prev + 1];
        }
        int take = 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + dfs(nums, idx + 1, idx);
        }
        int nottake = 0 + dfs(nums, idx + 1, prev);
        return dp[idx][prev + 1] = Math.max(take, nottake);
    }
}