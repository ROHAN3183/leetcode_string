class Solution {
    Boolean[] dp;

    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length];
        return dfs(nums, 0);
    }

    boolean dfs(int[] nums, int idx) {
        if (idx >= nums.length - 1) {
            return true;
        }
        if (nums[idx] == 0) {
            return false;
        }
        if (dp[idx] != null) {
            return dp[idx];
        }
        for (int i = 1; i <= nums[idx]; i++) {
            if (dfs(nums, idx + i)) {
                return dp[idx] = true;
            }
        }
        dp[idx] = false;
        return dp[idx];
    }
}