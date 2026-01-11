class Solution {
    Integer[][][] dp;

    public int wiggleMaxLength(int[] nums) {
        dp = new Integer[nums.length][nums.length][3];
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, 1 + dfs(nums, i, i + 1, 2));
        }
        return result;
    }

    int dfs(int[] nums, int prev, int curr, int prevSign) {
        if (curr >= nums.length) {
            return 0;
        }
        if (nums[curr] - nums[prev] == 0) {
            return dp[prev][curr][prevSign] = dfs(nums, prev, curr + 1, prevSign);
        }
        if (dp[prev][curr][prevSign] != null) {
            return dp[prev][curr][prevSign];
        }

        int currSign = 2;
        if (nums[curr] - nums[prev] < 0) {
            currSign = 0;
        } else if (nums[curr] - nums[prev] > 0) {
            currSign = 1;
        }

        int take = 0;
        if (prevSign == 2 || prevSign != currSign) {
            take = 1 + dfs(nums, curr, curr + 1, currSign);
        }
        int skip = dfs(nums, prev, curr + 1, prevSign);

        return dp[prev][curr][prevSign] = Math.max(take, skip);
    }
}