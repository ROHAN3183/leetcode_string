class Solution {
    public int rob(int[] nums) {
        int[] dp1 = new int[101];
        int [] dp2=new int [101];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        if (nums.length == 0)
            return 0;
        if (nums.length <= 1)
            return nums[0];

        return Math.max(dfs1(nums, 0, dp1), dfs2(nums, 1, dp2));
    }

    int dfs1(int[] nums, int idx, int[] dp1) {
        if (idx >= nums.length - 1) {
            return 0;
        }
        if (dp1[idx] != -1) {
            return dp1[idx];
        }
        int take = nums[idx] + dfs1(nums, idx + 2, dp1);
        int skip = 0 + dfs1(nums, idx + 1, dp1);

        return dp1[idx] = Math.max(take, skip);
    }

    int dfs2(int[] nums, int idx, int[] dp2) {
        if (idx >= nums.length) {
            return 0;
        }
        if (dp2[idx] != -1) {
            return dp2[idx];
        }
        int take = nums[idx] + dfs2(nums, idx + 2, dp2);
        int skip = 0 + dfs2(nums, idx + 1, dp2);

        return dp2[idx] = Math.max(take, skip);
    }
}