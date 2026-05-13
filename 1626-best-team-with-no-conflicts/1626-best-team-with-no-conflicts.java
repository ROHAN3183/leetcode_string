class Solution {
    Integer[][] dp;

    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] nums = new int[scores.length][2];
        dp = new Integer[nums.length][nums.length + 1];
        for (int i = 0; i < ages.length; i++) {
            nums[i] = new int[] { ages[i], scores[i] };
        }
        Arrays.sort(nums, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });
        return dfs(nums, 0, -1);

    }

    int dfs(int[][] nums, int idx, int prev) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp[idx][prev + 1] != null) {
            return dp[idx][prev + 1];
        }
        int take = 0;
        if (prev == -1 || (nums[idx][0] == nums[prev][0] && nums[idx][1] == nums[prev][1])) {
            take = nums[idx][1] + dfs(nums, idx + 1, idx);
        } else if (prev == -1 || nums[idx][1] >= nums[prev][1]) {
            take = nums[idx][1] + dfs(nums, idx + 1, idx);
        }
        int nottake = 0 + dfs(nums, idx + 1, prev);
        return dp[idx][prev + 1] = Math.max(take, nottake);

    }
}